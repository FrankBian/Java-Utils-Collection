package com.gansuer.others.singleton;

/**
 * Created by Frank on 4/22/16.
 */
public class Singleton5 {

    private static volatile Singleton5 instance;

    private Singleton5() {
    }

    /* This doesn't work with Java 1.4 or earlier*/
    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) instance = new Singleton5();
            }
        }
        return instance;
    }

}
