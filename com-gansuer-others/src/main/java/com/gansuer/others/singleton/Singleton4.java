package com.gansuer.others.singleton;

/**
 * Created by Frank on 4/22/16.
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) instance = new Singleton4();
            }
        }
        return instance;
    }
}
