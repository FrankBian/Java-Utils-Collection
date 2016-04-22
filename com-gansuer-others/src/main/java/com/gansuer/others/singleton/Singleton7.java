package com.gansuer.others.singleton;

/**
 * Created by Frank on 4/22/16.
 */
public enum Singleton7{

    SINGLETON_7("singleton");

    private String name;

    Singleton7(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
