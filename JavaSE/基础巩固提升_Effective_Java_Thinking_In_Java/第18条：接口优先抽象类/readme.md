在Java中提供两种机制，可以允许定义多个实现的类型：接口和抽象类。
####为什么优先使用接口而不是抽象类？

Think in java中提到`确定接口是理想的选择，因而应该总是选择接口而不是具体类`,其实这是一种引诱，人们往往滥用接口，对于创建类，几乎任何时刻都能替代接口和工厂。任何抽象性都应该是应真正的需求而产生的，恰到的原则是：`优先选择类而不是接口`。从类开始，如果接口的必需性变得非常明确，那么进行重构！

####牵引出的基础知识
####抽象类
抽象类需要用关键字`abstract`修饰类和方法来表明这是一个抽象类，被abstract的方法没有方法体，形式：
```
public abstract class ClassName {
    private int id;
    public void int setId(int id) {
        this.id = id;
    }
    public abstract void test();
    // ... 
}
```
在抽象类中可以有非abstract方法和域，抽象类不能被实例化，需要引用其子类的实例化。
####接口
接口需要用interface来定义，需要用implements实现接口。类中默认方法权限`public abstract`,默认域`static final`, 形式如下：
```
public interface Car {
    public static final int STEERING_WHEEL = 1; // == int STEERING_WHEEL = 1;
    public abstract String brandCar(String brand); // == String brandCar(String brand);
    //...
}

public class Tractor implements Car {

    @Override
    public String brandCar(String brand) {
        System.out.println("this is car's brand :" + brand + " and steering wheel of counts :" + STEERING_WHEEL);
    }
}
```
需要注意使用接口多重继承时防止方法名一致的情况，以避免不必要的错误。还有就是接口可以实现多重继承，而类只支持单继承。


接口优先于抽象类
