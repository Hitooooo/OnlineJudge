package com.offer.sword;

public class Singleton {
    /**
     * 私有构造
     */
    private Singleton() {
    }

    private static volatile Singleton instance;

    /**
     * 单线程中是没有问题的。但是在多线程的情况下，如果两个线程同时判断 instance == null，那么就会创建两个instance.
     * 最简单的方法，就是在方法上添加synchronized,但是这样的效率是很低的。如果实例已经创建成功了。即使是多线程访问实例 直接返回就行了，没必要阻塞。
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance2(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }    
        }
        return instance;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance3() {
        return SingletonHolder.INSTANCE;
    }
}