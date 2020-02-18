# 面试题2-实现Singleton模式.md

#### 双重检测锁
这个应该`java`标准的双重检测锁式的单例模式吧：
```java
public class Singleton{

    private static volatile  Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

另外，《剑指Offer》中利用C#的一些特性提出了两种强烈推荐的写法，不过学艺不精不知道转成Java应该是怎么写的，就先记录在这里吧：<br/>
>
> **强烈推荐的解法一：利用静态构造函数**<br/>
```c#
public sealed class Singleton4{
  public Singleton4(){
  }

  private static Singleton4 instance = new Singleton4();
  public static Singleton4 Instance{
    get 
    {
       return instance;
    }
  }
}
```
> **强烈推荐的解法二：实现按需创建实例**<br/>
```c#
public sealed class Singleton5{
  public Singleton5()
  {
  }

  public static Singleton5 Instance{
    get 
    {
       return Nested.instance;
    }
  }

  class Nested
  {
     static Nested()
     {
     }

     internal static readonly Singleton5 instance = new Singleton5();
  }
}
```

另外常见的单例模式还有`饿汉式`和`懒汉式`，下面简单举例：
```java
//饿汉式 -- 线程安全
public class SingletonDemo1 {

    //线程安全的
    //类初始化时，立即加载这个对象
    private static SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1() {
    }

    //方法没有加同步块，所以它效率高
    public static SingletonDemo1 getInstance() {
        return instance;
    }
}

//懒汉式 - 线程不安全 
public class SingletonDemo2 {

    //线程不安全的

    private static SingletonDemo2 instance = null;

    private SingletonDemo2() {
    }

    //运行时加载对象
    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }

}
```
双重检测锁算是线程安全版的`懒汉式`。


相关链接
----
* [《剑指Offer》源码链接](https://github.com/zhedahht/CodingInterviewChinese2/tree/master/02_Singleton)
* [Java设计模式（一）之单例模式](https://www.jianshu.com/p/3f5eb3e0b050)
