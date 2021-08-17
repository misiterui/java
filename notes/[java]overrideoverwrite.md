# [java]override/overwrite 重写

### 定义

在子类中可以根据需要对从父类中继承来的方法进行改造， 也称为方法的重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。  

### 要求

- 子类重写的方法必须和父类被重写的方法具有相同的方法名称、参数列表

  ```java
  // 父类
  public class Person { 
      public String name; public int age; 
      public String getInfo() {
          return "Name: "+ name + "\n" +"age: "+ age;
      }
  }
  
  // 子类
  public class Student extends Person {
      public String school;
      public String getInfo() { //重写方法
          return "Name: "+ name + "\nage: "+ age + "\nschool: "+ school;
      }
      
  	public static void main(String args[]){
          Student s1=new Student();
          s1.name="Bob";
          s1.age=20;
          s1.school="school2";
          System.out.println(s1.getInfo()); //Name:Bob age:20 school:school2
      }
  }
  
  // 测试
  Person p1=new Person(); 
  p1.getInfo();//调用Person类的getInfo()方法
  Student s1=new Student();
  s1.getInfo();//调用Student类的getInfo()方法
  // 这是一种“多态性”：同名的方法，用不同的对象来区分调用的是哪一个方法。
  ```

- 子类重写的方法的返回值类型不能大于父类被重写的方法的返回值类型

  | 父类         | 子类                 |
  | ------------ | -------------------- |
  | void         | void                 |
  | A类型        | A类型或A类型的子类型 |
  | 基本数据类型 | 相同的基本数据类型   |

  比如：Object –> String (Object被重写为String)

- 子类重写的方法使用的访问权限不能小于父类被重写的方法的访问权限

  - 子类不能重写父类中声明为`private`权限的方法(对子类来说，父类中private的东西时看不到的)

    ```java
    // 父类
    class Parent {
    	public void method1() {}
    }
    
    // 子类
    class Child extends Parent {
    	//非法，子类中的method1()的访问权限private比被覆盖方法的访问权限public小
    	private void method1() {}
    }
    ```

    

- 子类方法抛出的异常不能大于父类被重写方法的异常

注意：子类与父类中同名同参数的方法必须同时声明为非static的(即为重写)，或者同时声明为static的(不是重写)。因为static方法是属于类的，子类无法覆盖父类的方法。

