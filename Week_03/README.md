学习笔记

NIO支持的三种模式：
Reactor单线程模式
非主从Reactor多线程模式
主从Reactor多线程模式

主从Reactor多线程模式：有两个Group，分别是Boss Group，Worker Group。Group里包含EventLoop，每个EventLoop可以绑定多个Channel。每个channel只能注册到一个eventLoop，然后就只从这个eventloop拿数据，交给handler处理。

