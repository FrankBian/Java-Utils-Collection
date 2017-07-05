package com.gansuer.framewok.wheel.rpc.importer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Frank on 11/16/2016.
 */
public class RpcImporter<S> {

    public S importer(final Class<?> serviceClazz, final InetSocketAddress address) {
        return (S) Proxy.newProxyInstance(serviceClazz.getClassLoader(), new Class<?>[]{serviceClazz.getInterfaces()[0]},
                (proxy, method, args) -> {
                    Socket socket = null;
                    ObjectOutputStream output =null;
                    ObjectInputStream input = null;
                    try {
                        socket = new Socket();
                        socket.connect(address);
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(serviceClazz.getName());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        input = new ObjectInputStream(socket.getInputStream());
                        return input.readObject();
                    }finally {
                        if (socket != null) socket.close();
                        if (output != null) output.close();
                        if (input != null) input.close();
                    }
                });
    }
}
