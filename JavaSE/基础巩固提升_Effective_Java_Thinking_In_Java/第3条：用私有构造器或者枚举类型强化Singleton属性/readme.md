###实现Singleton的有三种方法
- 通过把构造器设为私有并导出公有的静态成员
```
public class Demo {
    public static final Demo INSTANCE = new Demo();　//final保证了构造器只调用一次
    private Demo() {
        //...
    }
}
```
- 通过将构造器设为私有，并设置私有的静态成员，通过`静态工厂方法`返回实例
```
public class Demo {
    private static final Demo INSTANCE = new Demo();

    private Demo() {
        //...
    }

    public static Demo getInstance() {
        return INSTANCE;
    }
}
```
- 通过单个元素的枚举类型实现Singleton(最佳的方法)
```
public enum Singleton {
    INSTANCE {

        @Override
        protected void read() {
            System.out.println("read");
        }

        @Override
        protected void write() {
            System.out.println("write");
        }

    };
    protected abstract void read();
    protected abstract void write();
}
```

###为什么枚举会是实现Singleton最佳的方案？
- 通过公有的final的静态域的方法，保证实例化的对象相同，但是现代的JVM实现几乎都能够将静态工厂方法的调用内联化．
- 在`static final`成员基础上的静态工厂方法实现的Singleton序列化时，实例域必须是`transient`，而且并提供一个`readResolve`方法，否则每反序列化一次就会实例化一次．
- JDK1.5出现的枚举，无偿提供了序列化机制，防止多次实例化，线程安全，防止反射机制的修改．

对于通过private构造器实现的Singleton可以通过反射机制进行修改的，要优先考虑枚举实现Singleton．

###牵扯到的知识点
####private,protected,public,default的访问权限
被private修饰的属性或方法，只有自身类才能访问到．
被protected修饰的属性或方法，子类或同包下类的能访问到．
被public修饰的属性或方法，任何类都能访问．
没有修饰词(default)的属性或方法，只有同包下的类能访问到

####[Java枚举](https://github.com/zhaohuXing/JavaKnowledge/tree/master/JavaSE/enum)
