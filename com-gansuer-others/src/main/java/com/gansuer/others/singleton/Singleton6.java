package com.gansuer.others.singleton;

/**
 * Created by Frank on 4/22/16.
 */
public class Singleton6 {

    private Singleton6() {

    }

    public static Singleton6 getInstance(){
        return InstanceHolder.instance;
    }
    private static class InstanceHolder {
        private static final Singleton6 instance = new Singleton6();
    }
}
