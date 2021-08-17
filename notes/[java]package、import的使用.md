# [java]package、import的使用

### package

package语句作为Java源文件的第一条语句，指明该文件中定义的类所在的包。 (若缺省该语句，则指定为无名包)。它的格式为:

​				`package 顶层包名.子包名;  `

- 包对应于文件系统的目录， package语句中，用 “.” 来指明包(目录)的层次；  
- 包通常用小写单词标识。通常使用所在公司域名的倒置： com.公司名.xxx  
- 每`.`一次，就代表一层文件目录
- 使用`package`声明类或接口所属的包，声明在源文件的首行
- 同一个包下，不能命名同名的接口、类；不同的包下，可以命名同名的接口、类



### JDK中主要的包  

1. java.lang----包含一些Java语言的核心类， 如String、 Math、 Integer、 System和Thread， 提供常用功能
2. java.net----包含执行与网络相关的操作的类和接口。
3. java.io ----包含能提供多种输入/输出功能的类。
4. java.util----包含一些实用工具类， 如定义系统特性、 接口的集合框架类、 使用与日期日历相关的函数
5. java.text----包含了一些java格式化相关的类
6. java.sql----包含了java进行JDBC数据库编程的相关类/接口
7. java.awt----包含了构成抽象窗口工具集（abstract window toolkits） 的多个类， 这些类被用来构建和管理应用程序的图形用户界面(GUI)。 B/S C/S  



### import

- 为使用定义在不同包中的Java类，需用import语句来引入指定包层次下所需要的类或全部类(.*)。 import语句告诉编译器到哪里去寻找类。  
- 语法格式：  `import 包名. 类名; `

##### 注意

- 在源文件中使用import显式的导入指定包下的类或接口

- 声明在包的声明和类的声明之间

- 如果需要导入多个类或接口，那么就并列显式多个import语句即可

- 举例：可以使用java.util.*的方式，一次性导入util包下所有的类或接口  

- 如果导入的类或接口是java.lang包下的，或者是当前包下的，则可以省略此import语句  

- 如果在代码中使用不同包下的同名的类。那么就需要使用类的全类名的方式指明调用的是哪个类  

  - ```java
    // 不用import，而是在行内这样写
    com.practice.exer3.Account account1 = new com.practice.exer3.Account();
    com.practice.exer4.Account account2 = new com.practice.exer4.Account();
    ```

- 如果已经导入java.a包下的类。那么如果需要使用a包的子包下的类的话，仍然需要导入  

- import static组合的使用：调用指定类或接口下的静态的属性或方法  

