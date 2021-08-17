# [java]instanceof

`x instanceof A` 

检验x是否为类A的对象，返回值为boolean型。

- 要求x所属的类与类A必须是子类和父类的关系，否则编译错误
- 若x属于类A的子类B，x instanceof A 值也为true.

```java
public class Person extends Object {…}
public class Student extends Person {…}
public class Graduate extends Person {…}
-------------------------------------------------------------------
public void method1(Person e) {
	if (e instanceof Person)
		// 处理Person类及其子类对象
	if (e instanceof Student)
		//处理Student类及其子类对象
	if (e instanceof Graduate)
		//处理Graduate类及其子类对象
}
```



### 子类继承父类

- 若子类重写了父类的方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，系统将不可能把父类里的方法转移到子类中。
- 对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，这个实例变量已然不可能覆盖父类中定义的实例变量。

```java
// 属性不体现多态性，方法体现多态性
class Base {
	int count = 10;
	public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;
    public void display() {
        System.out.println(this.count);
    }
}

public class FieldMethodTest {
    public static void main(String[] args){
        Sub s = new Sub();
        System.out.println(s.count); //20 - 先找自己的field，找不到再去父类中找
        s.display(); //20
        Base b = s; //将s的地址赋给b
        System.out.println(b == s); //true - 地址一样
        System.out.println(b.count); //10 - 属性没有多态性
        b.display(); //20 - 方法有多态性，虚拟方法调用
    }
}
```



### 向上转型

多态

### 向下转型

使用强制类型转换符：()

```java
Object o = new Object();
String s = (String) o;
```

##### 注意

- 使用强转时，可能出现ClassCastException的异常。
- 为了避免在向下转型时出现ClassCastException的异常，在向下转型之前，先进行instanceof的判断，一旦返回true，就进行向下转型。若返回false，不进行向下转型。