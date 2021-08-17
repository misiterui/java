# [java]可变个数的形参

JavaSE 5.0 中提供了Varargs(variable number of arguments)机制，允许直接定义能和多个实参相匹配的形参。从而，可以用一种更简单的方式，来传递个数可变的实参。 

-  JDK 5.0以前： 采用数组形参来定义方法，传入多个同一类型变量  

  ```java
  public static void test(int a ,String[] books);
  ```

- JDK5.0： 采用可变个数形参来定义方法，传入多个同一类型变量  

  ```java
  public static void test(int a ,String…books);
  ```



### 声明格式

`方法名(参数的类型名...参数名)`

- 可变参数：
  - 方法参数部分指定类型的参数个数是可变多个： 0个， 1个或多个  

- 可变个数形参的方法与同名的方法之间，彼此构成重载  
- 方法的参数部分有可变形参，需要放在形参声明的最后  
- 在一个方法的形参位置，最多只能声明一个可变个数形参  



