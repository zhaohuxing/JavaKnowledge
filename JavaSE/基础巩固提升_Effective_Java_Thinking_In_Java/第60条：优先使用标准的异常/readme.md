#### Why
- 考虑代码重用性
- 易读性
- 内存小，时间开销小

代码重用是值得提倡的，异常也不例外。对于其他读者，熟悉最好不过了，增加易读性。异常类越少，意味着内存印记就越少，装载这些类的时间开销也越少。

#### How

异常 | 使用场合
-------|------------
IllegalArgumentException | 用于参数非法
IllegalStateException | 对于调用方法而言，对象的状态不合适
NullPointerException | 防止null
IndexOutOfBoundsExceptioin | 防止数组越界
ConcurrentModificationException | 在禁止并发修改的情况下，检测到对象的并发修改
UnsupportedOperationException | 对象不支持用户请求的方法

常用的几个异常，当然还有其他。选择重用哪个异常并不总是那么精确，灵活使用。

