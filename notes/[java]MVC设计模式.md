# [java]MVC设计模式

MVC是常用的设计模式之一，将整个程序分为三个层次： 视图模型层，控制器层，与数据模型层。 这种将程序输入输出、数据处理，以及数据的展示分离开来的设计模式使程序结构变的灵活而且清晰，同时也描述了程序各个对象间的通信方式，降低了程序的耦合性。  

- 模型层 model 主要处理数据  

  - 数据对象封装 model.bean/domain  
  - 数据库操作类 model.dao  
  - 数据库 model.db  

- 视图层 view 显示数据  

  - 相关工具类 view.utils  
  - 自定义view view.ui  

- 控制层 controller 处理业务逻辑  

  - 应用界面相关 controller.activity 

  - 存放fragment controller.fragment

  - 显示列表的适配器 controller.adapter

  - 服务相关的 controller.service
  
  - 抽取的基类 controller.base