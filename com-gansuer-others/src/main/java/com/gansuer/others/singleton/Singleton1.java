package com.gansuer.others.singleton;

/**
 * Created by Frank on 4/22/16.
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
