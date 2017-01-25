>说在前面，每天积累一点点，详情请点击[github](https://github.com/zhaohuXing/JavaKnowledge)

在继承方面说，如果实现子类化，该类必须具有public/protected的构造器．在缺少显示构造器的情况下，编译器会自动提供一个公有的，无参的缺省构造器．
如果一个类不想被实例化，可以将其设置为私有的。通常都是将构造器设为private,并提供一个public 的域或方法供其使用。
举个栗子：
```
public class Singleton {
    public static final Singleton INSTANCE = new Singleton();
    private Singleton() {
        //...
    }
}
```
