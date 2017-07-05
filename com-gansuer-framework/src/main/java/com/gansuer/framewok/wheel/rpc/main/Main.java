package com.gansuer.framewok.wheel.rpc.main;

import com.gansuer.framewok.wheel.rpc.exporter.RpcExporter;
import com.gansuer.framewok.wheel.rpc.importer.RpcImporter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Frank on 11/16/2016.
 */
public class Main {

    public static void main(String[] args){
        new Thread(() -> {
            try {
                RpcExporter.exporter("localhost",8088);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        RpcImporter<ExampleService> importer = new RpcImporter<>();
        ExampleService exampleService = importer.importer(ExampleServiceImpl.class,new InetSocketAddress("localhost",8088));
        System.out.println(exampleService.greeting("Hi Server"));
    }
}
