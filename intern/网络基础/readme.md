##众多协议栈中的两种典型的模型：
OSI模型:
- 应用层
- 表示层
- 会话层
- 传输层
- 网络层
- 数据链路层
- 物理层

##TCP/IP参考模型(因特网协议栈)
- 应用层
- 传输层
- 网络层
- 数据链路层
- 物理层

注:TCP/IP实际应用将数据链路层和物理层看成网络接口层，为了介绍网络原理就分开了。

TCP/IP参考模型中的各层对应OSI模型的各层，但是没有表示层和会话层，这是为什么呢？难道它们不重要吗？当然不是啦,当将OSI模型具体化时，就要使之成为因特网协议栈(TCP/IP参考模型)。表示层通常负责数据压缩，数据加密以及数据的描述。会话层通常负责提供数据交换的定届和同步功能，如果应用程序的需要其中的这些服务之一，就由开发人员在应用程序里构建。

各层中的协议:
应用层: HTTP/HTTPS(Web), Telnet(远程终端访问), FTP(文件传输)，SMTP(电子邮件)， DNS(域名解析)
传输层: TCP(传输控制协议)， UDP(用户数据包协议)
网络层: IP(网际协议)，ICMP(互联网控制报文协议), ARP(地址解析协议)
数据链路层: PPP(点对点协议), CSMA/CD(载波监听多点接入和碰撞检测) 
物理层:

2017.02.20暂记
应用层的协议
数据链路层协议
DNS劫持，DNS污染
网络层 TCP
