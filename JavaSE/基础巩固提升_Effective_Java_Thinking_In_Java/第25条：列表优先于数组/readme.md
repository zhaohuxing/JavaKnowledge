>说在前面，每天积累一点点，详情请点击[github](https://github.com/zhaohuXing/JavaKnowledge)

如题，按照“列表优于数组”的原则，列表相对于数组一定有它的优势。我们要了解数组和泛型有两大区别。
###第一大区别
数组是“协变”的，意思就是如果Sub是Super的子类，那么Sub[]也是Super[]的子类。下面的代码助咱理解协变的含义
```
    //这三行代码可以编译，但是不能被执行,报ArrayStoreException的错
    Object[] objectArray = new Long[2]; // 协变 
    objectArray[0] = 2017; //正确
    objectArray[1] = "happy new year"; // ArrayStoreException 
```
然而，泛型则是“不可变”的，Employee 是Person的子类，但是List<Person>和List<Employee>没有任何关联。
```
    //不能通过编译
    List<Person> list = new ArrayList<Employee>();
    //数组中栗子
    List<Object> list = new ArrayList<Long>();//不能编译 
```
针对于上述情况，使用泛型会提前发现bug,数组到运行时才发现的，由此可见泛型实现要比数组好些。

###第二大区别
数组是可具体化的，在运行时，严格检查其类型，泛型则相反，在编译时强化其类型，并在运行时丢弃其类型即类型擦除。所以数组和泛型不能混合使用。

###禁止创建泛型数组
泛型数组是类型不安全的，在运行时会发生ClassCastException异常。当发生泛型数组错误时，考虑使用List<E>，而不是E[]。

###牵引出的基础知识
####泛型
####线程同步
