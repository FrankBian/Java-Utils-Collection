package com.gansuer.others.singleton;

/**
 * Created by Frank on 4/22/16.
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){
    }

    public static Singleton3 getInstance(){
        synchronized (Singleton3.class){
            if (instance == null) instance = new Singleton3();
        }
        return instance;
    }
}
