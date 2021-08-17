# [java]Object类的使用

Object类是所有Java类的根父类

如果在类的声明中未使用extends关键字指明其父类， 则默认父类为java.lang.Object类

### Object类中的主要结构

| No.  | 方法名称                          | 类型 | 描述                |
| ---- | --------------------------------- | ---- | ------------------- |
| 1    | public Object()                   | 构造 | 构造器              |
| 2    | public boolean equals(Object obj) | 普通 | 对象比较            |
| 3    | public int hashCode()             | 普通 | 取得Hash码          |
| 4    | public String toString()          | 普通 | 对象打印时调用      |
| 5    | protected Object clone()          |      | 对象复制(deep copy) |



### ==操作符 & equals方法

##### ==

- 基本类型比较值，只要两个变量的值相等，即为true。

  - 数据类型不一定相同，但符号两边的数据类型必须兼容（可自动转换的基本数据类型除外），否则编译出错。

  ```java
  int i = 10;
  char c = 10;
  boolean b = true;
  System.out.println(i==b); // 编译错误，boolean类型不能与其他数据类型比较
  System.out.println(i==c); // true
  ```

- 引用类型比较引用（是否指向同一个对象）：只有指向同一个对象时，==才返回true。

  ```java
  String str1 = "abc";
  String str2 = "abc";
  System.out.println(str1==str2); // false - 并不指向同一对象
  ```

- == 符号使用时，必须保证符号左右两边的变量类型一致。

  ```java
  System.out.println(“hello” == new java.util.Date()); //编译不通过
  ```

  

##### equals()

所有类都继承了Object，也就获得了equals()方法。（可重写）

- 只能比较引用数据类型，其作用与“==”相同，比较是都指向同一个对象。

- 格式：obj1.equals(obj2)

- 特例：当用equals()方法进行比较时， 对类File、 String、 Date及包装类（Wrapper Class） 来说， 是比较类型及内容而不考虑引用的是否是同一个对象

  - 原因：在这些类中重写了Object类的equals()方法。  

  ```java
  String str1 = "abc";
  String str2 = "abc";
  System.out.println(str1.equals(str2)); //true
  ```

- 当自定义使用equals()时， 可以重写。 用于比较两个对象的“内容” 是否都相等  

  ```java
  @Override
  public boolean equals(Object obj){
      if(this == obj){
          return true;
      }
      if (obj instanceof MyDate){
          MyDate myDate = (MyDate) obj;
          return this.day == myDate.day && this.month == myDate.month && this.year == myDate.year;
      }
      return false;
  }
  ```

  

### 重写equals()方法的原则  

- 对称性： 如果x.equals(y)返回是“ true” ， 那么y.equals(x)也应该返回是“true” 。
- 自反性： x.equals(x)必须返回是“true” 。  
- 传递性： 如果x.equals(y)返回是“true” ， 而且y.equals(z)返回是“true” ，那么z.equals(x)也应该返回是“true” 。  
- 一致性： 如果x.equals(y)返回是“true” ， 只要x和y内容一直不变， 不管你重复x.equals(y)多少次， 返回都是“true” 。  
- 任何情况下， x.equals(null)， 永远返回是“false” ；x.equals(和x不同类型的对象)永远返回是“false” 。  



### == & equals 区别

1. == 既可以比较基本类型也可以比较引用类型。对于基本类型就是比较值，对于引用类型就是比较内存地址  
2. equals的话，它是属于java.lang.Object类里面的方法，如果该方法没有被重写过默认也是==;我们可以看到String等类的equals方法是被重写过的，而且String类在日常开发中用的比较多，久而久之，形成了equals是比较值的错误观点。  
3. 具体要看自定义类里有没有重写Object的equals方法来判断。  
4. 通常情况下，重写equals方法，会比较类中的相应属性是否都相等。  



### String和常量池

```java
String s1 = "AA";
String s2 = "AA";
System.out.println(s1==s2); //true - 因为此时"AA"这个常量存在常量池中，s1,s2都指向它
```

