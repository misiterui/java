# [java]final

在Java中声明类、 变量和方法时， 可使用关键字final来修饰,表示“最终的”。

- final标记的类不能被继承。 提高安全性， 提高程序的可读性。
  - String类、 System类、 StringBuffer类
- final标记的方法不能被子类重写。
  - 比如： Object类中的getClass()。
- final标记的变量(成员变量或局部变量)即称为常量。 名称大写， 且只能被赋值一次。
  - final标记的成员变量必须在声明时或在每个构造器中或代码块中显式赋值， 然后才能使用。
  - final double MY_PI = 3.14;  

### final修饰类  

```java
final class A{}
class B extends A{} //错误，不能被继承。
```

中国古代，什么人不能有后代，就可以被final声明， 称为“太监类”！  

### final修饰方法  

```java
class A {
    public final void print() {
        System.out.println("A");
    }
}

class B extends A {
    public void print() { // 错误，不能被重写。
        System.out.println("尚硅谷");
    }
}
```

### final修饰变量——常量

- final修饰属性，可以考虑的赋值位置有：
  - 显式初始化 `final int WIDTH = 0;`
  - 代码块中初始化 `final int LEFT; {LEFT = 1;}`
  - 构造器中初始化
- final修饰局部变量
  - 尤其使用final修饰形参时，表明此形参时一个常量。
  - 当我们调用此方法时，给常量形参赋一个实参。一旦赋值后，就只能在方法体内使用形参，但不能进行重新赋值。
- `static final  `：全局常量

```java
class A {
    private final String INFO = "atguigu"; //声明常量
    public void print() {
        //The final field A.INFO cannot be assigned
        //INFO = "尚硅谷";
    }
}
```

常量名要大写，内容不可修改。 ——如同古代皇帝的圣旨。





### 例

```java
public final class Test {
    public static int totalNumber = 5;
    public final int ID;
    
    public Test() {
        ID = ++totalNumber; // 可在构造器中给final修饰的“变量”赋值
    }
    
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.ID);
        final int I = 10;
        final int J;
        J = 20;
        J = 30; // 非法
    }
}
```



### 面试题

排错

```java
public class Something {
    public int addOne(final int x) {
        return ++x; // x值无法更改
        // return x + 1; 可以
    }
}
```

```java
public class Something {
    
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }
    
    public void addOne(final Other o) {
        // o = new Other();
        o.i++;
    }
}

class Other {
    public int i;
}
```

虽然static的对象不可改，但对象的属性可以改。

比如：媳妇儿不可改，但媳妇儿的年龄会增加。