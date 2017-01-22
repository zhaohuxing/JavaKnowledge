允许程序把“调用特殊函数的能力”存储起来并传递这种能力。
这种机制通常同于允许函数的调用者通过传入第二个函数，来指定自己的行为。
####什么是函数对象？
当一个函数中的局部变量无法“提炼出函数”时，考虑将这个函数提取出来封装成一个该函数功能的类，其局部变量即成为其域，这样的类的实例我们称之为函数对象。
####什么是策略模式？
策略模式，顾名思义就是做某事的策略，这在编程上通常是指完成某个操作可能有多种方法，这些方法各有千秋，可能有不同的适合的场合，然而这些操作方法都有可能被用到。把各个操作方法都当做一个实现策略，使用者可以根据需求选择合适的策略。

![策略模式.jpg](http://upload-images.jianshu.io/upload_images/2031765-8b63ae1df2bbe104.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Context:使用不同策略的环境，它可以根据自身的条件选择不同的策略实现类来完成所要的操作。它持有一个策略实例的引用。创建具体策略对象的方法也可以由它完成。
Strategy:抽象策略。定义了每个策略都要实现的方法。Strategy既可以是接口又可以是抽象类。按照《Effective Java》第二版中的第18条接口优于抽象类。建议使用接口来是实现Strategy.
ConcreteStrategy:具体策略实现类，实现在抽象策略中定义的策略方法。

举个栗子：
驾照科三考试，考试车参差不齐，有奇瑞，新捷达，老捷达。考试科目只有灯光不一样，其余的都一样。
```
public interface Car {
    void lightSimulate();
    void otherProgram();
}

public class CarOfJieda implements Car {
    @Override
    public void lightSimulate() {
        System.out.println("向上转两次，开启近光灯");
        System.out.println("向下拨开启远光灯");
        System.out.println("向上拨两次近远光灯交替");
        System.out.println("向下转两次关闭灯光");
    }

    @Override
    public void otherProgram() {
        System.out.println("起步");
        System.out.println("...........");
        System.out.println("考试合格请求大厅打印成绩");
    }
}

public class CarOfOldJieda implements Car {
    @Override
    public void lightSimulate() {
        System.out.println("向右转两次，开启近光灯");
        System.out.println("向上拨开启远光灯");
        System.out.println("向上拨关闭远光灯");
        System.out.println("向上拨四次近远光灯交替");
        System.out.println("向左转两次关闭灯光");
    }

    @Override
    public void otherProgram() {
        System.out.println("起步");
        System.out.println("...........");
        System.out.println("考试合格请求大厅打印成绩");
    }
}

public class CarOfQirui implements Car {
    @Override
    public void lightSimulate() {
        System.out.println("向上转两次，开启近光灯");
        System.out.println("向下拨开启远光灯");
        System.out.println("向上拨两次近远光灯交替");
        System.out.println("向下转两次关闭灯光");
    }

    @Override
    public void otherProgram() {
        System.out.println("起步");
        System.out.println("...........");
        System.out.println("考试合格请求大厅打印成绩");
    }
}

public class RoadTest {
    private Car car;

    public RoadTest(Car car) {
        this.car = car;
    }

    public void test() {
        System.out.println("确认身份"); 
        car.lightSimulate();
        car.otherProgram();
    }

    public static void main(String[] args) {
        RoadTest rt = new RoadTest(new CarOfJieda());
        rt.test();
    } 
}
```
Car相当于Strategy, CarOfxxx相当于ConcreteStrategy, RoadTest相当于Context

####怎么用函数对象表示策略？
###牵引出的基础知识
####策略模式
####单例模式
