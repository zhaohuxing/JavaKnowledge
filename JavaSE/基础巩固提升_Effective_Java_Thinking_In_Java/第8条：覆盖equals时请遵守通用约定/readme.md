按照规定的约束进行覆盖，传递性，自反性，== instanceof.
- 使用==操作符检查"参数是否为这个这个对象的引用"
- 使用instanceof操作符检查参数是否正确类型
- 把参数转换成正确的类型
- 对于该类中每个"关键"域，检查参数中的域是否与该对象中的域相匹配．
- 编写完，考虑是否符合　对称性，传递性，一致性．（自反性和非空性一般都符合）
- 覆盖equals也覆盖重写hashCode()
- 不要将equal中的Object参数类型转换成其他的类型

大白话：
equals参数类型Object不要更改，使用instanceof,检查对象的类型，并将参数转换成正确的类型，用==比较参数中的关键域是否与该对象中的域相等，写完后是否符合传递性，对称性，一致性．
```
private int id;
private String str;
@Override
public void equals(Object o) {
    if (o == this)  return ture;
    return o instanceof ClassName && id == ((ClassName)o).id && str.equals(((ClassName)o).str);
}
```
