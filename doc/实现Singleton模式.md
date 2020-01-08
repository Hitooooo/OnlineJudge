## 实现单例模式

1. 私有构造，不允许其他人创建实例
2. 提供可多线程获取唯一实例的方法

### 不好的解法

单线程中是没有问题的。但是在多线程的情况下，如果两个线程同时判断 instance == null，那么就会创建两个instance.最简单的方法，就是在方法上添加synchronized,但是这样的效率是很低的。如果实例已经创建成功了。即使是多线程访问实例直接返回就行了，没必要阻塞。

```java
public class Singleton {
    /**
     * 私有构造
     */
    private Singleton() {
    }

    private static Singleton instance;


    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    
}

```

### 代码块中加锁的方式

```java
// 实例添加volatile，禁止虚拟机重排初始化过程，防止其他线程获取到未初始化完全的实例
private static volatile Singleton instance;

public static Singleton getInstance2(){
    if(instance == null){
        synchronized(Singleton.class){
            // 为什么还要判断一次
            if(instance == null){
                instance = new Singleton();
            }
        }    
    }
    return instance;
}
```

* 只有实例为空才加锁
* 如果其他线程先获取了锁已经执行了实例化，需要在获取锁后再判断一次
* **注意对成员变量Instance添加 volatile 关键字** 

### 静态构造函数

以上方法，虽然实现了，并且效率较高，但是实现复杂，易出错。

```java
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance3() {
        return SingletonHolder.INSTANCE;
    }
```

通过静态内部类的方式，保证类只会被初始化一次。之后的每次获取都是同一个对象。简单直白。

### Spring是如何实现单例模式的？

单例注册表。[底层分析参考](https://www.cnblogs.com/aaron911/p/11074303.html)
