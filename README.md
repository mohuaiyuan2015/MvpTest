# MvpTest
Android MVP架构 demo

1.乞丐版MVP 
简易的MVP架构。

注意！以上代码中还存在很大的问题，不能用到实际开发中，下面会讨论目前存在的问题以及如何优化。


2.平民版MVP架构 - base层顶级父类

之前说过乞丐版MVP架构模式中还存在很多问题不能应用到实际的开发中，大概存在的问题有：

1)构架存在漏洞
2)代码冗余量大
3)通用性差
针对这些问题我们需要进一步优化，单车变摩托，升级为可以在实际开发中使用的平民版MVP架构。


3.时尚版MVP架构 - Model层的优化

时尚版MVP架构的Model层中，Presenter 请求数据不再直接调用具体的Model对象，统一以 DataModel 类作为数据请求层的入口，以常量类 Token 区别具体请求。 DataModel会根据Token的不同拉取底层对应的具体Model。

优化之后的Model层是一个庞大而且独立的模块，对外提供统一的请求数据方法与请求规则，这样做的好处有很多：

1)数据请求单独编写，无需配合上层界面测试。
2)统一管理，修改方便。
3)利用Token类可以直观的统计出已存在的请求接口。


添加Model的步骤
1)新建一个Model并继承BaseModel，完成具体的数据请求。
2)在Token中添加对用的Model包名+类名。注意写好注释，方便以后查阅。







