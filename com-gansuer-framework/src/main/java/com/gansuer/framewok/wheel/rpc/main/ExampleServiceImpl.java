package com.gansuer.framewok.wheel.rpc.main;

/**
 * Created by Frank on 11/16/2016.
 */
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String greeting(String word) {
        return "Input[" + word +"] -------> Output[Hi,I'm fine]";
    }
}
