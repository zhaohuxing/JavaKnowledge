实现Cloneable接口的类实例化的对象可以被克隆,但是Cloneable中不存在clone()方法.Object中含有`protected Object clone()`,有时访问权限不够,需要借助反射才能调用clone方法.

何时,如何实现一个行为良好的clone方法?
有哪些可代替方案?
无需调用构造器就可以创建对象，这种行为太过于强硬，行为良好的clone中可以通过构造器来创建对象，构造之后再复制内部数据。如果这个类是final的，clone 甚至可能会返回一个由构造器创建的对象。

如果覆盖了非final中clone方法，则应该返回一个通过通过调用super.clone()而得到的对象。如果该类的超类都遵循这条约定，那么调用super.clone()，最终会调用Object中的clone()方法。

如果一个类实现了Cloneable方法，并且它的超类都提供良好的clone方法。通过super.clone()得到对象，可能是最终要返回的对象，也可能不是。

上述两种结果跟类的本质有关。在该类中声明的域等同于被克隆对象中响应的域，如果该类中存在`基本数据类型的值`或`指向不可变对象的对引用`，那么你需要实现Cloneable方法，并提供可访问Object中clone的公有的访问途径. 如下代码。
举个栗子：
```
public ClassName clone() {
    try {
        return (ClassName)super.clone();
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
}
```


#牵引出的知识点
###反射
