package com.gansuer.framewok.wheel.rpc.exporter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Frank on 11/16/2016.
 */
public class RpcExporter {

    private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(final String host, final int port) throws IOException {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(host,port));
        try {
            while (true){
                executor.execute(new ExportTask(server.accept()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            server.close();
        }
    }

    private static class ExportTask implements Runnable{
        private Socket client = null;

        public ExportTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            ObjectInputStream ois = null;
            ObjectOutputStream ous = null;
            try {
                ois = new ObjectInputStream(client.getInputStream());
                String interfaceName = ois.readUTF();
                Class<?> service = Class.forName(interfaceName);
                String methodName = ois.readUTF();
                Class<?>[] paramTypes = (Class<?>[]) ois.readObject();
                Object[] arguments = (Object[]) ois.readObject();
                Method method = service.getMethod(methodName,paramTypes);
                Object result = method.invoke(service.newInstance(),arguments);
                ous = new ObjectOutputStream(client.getOutputStream());
                ous.writeObject(result);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (ous != null){
                    try {
                        ous.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ois != null){
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (client != null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
