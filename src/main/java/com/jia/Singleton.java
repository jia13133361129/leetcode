package com.jia;

public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){}

    public Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
