# [Java]this的使用  

1. 在任意方法或构造器内，如果使用当前类的成员变量或成员方法可以在其前面添加this，增强程序的阅读性。不过，通常我们都习惯省略this。  

2. 当形参与成员变量同名时，如果在方法内或构造器内需要使用成员变量，必须添加this来表明该变量是类的成员变量

3. 使用this访问属性和方法时，如果在本类中未找到，会从父类中查找  

4. this可以作为一个类中构造器相互调用的特殊格式  

   ```java
   class Person{ // 定义Person类
   	private String name;
   	private int age;
       
   	public Person(){ // 无参构造器
   		System.out.println("新对象实例化");
   	}
       
   	public Person(String name){
   		this(); // 调用本类中的无参构造器
   		this.name = name ;
   	}
   	public Person(String name,int age){
   		this(name) ; // 调用有一个参数的构造器
   		this.age = age;
   	}
   	public String getInfo(){
   		return "姓名： " + name + "，年龄： " + age ;
   	}
   }
   ```

   

### 注意

- 可以在类的构造器中使用"this(形参列表)"的方式，调用本类中重载的其他的构造器！  

- 明确：构造器中不能通过"this(形参列表)"的方式调用自身构造器

- 如果一个类中声明了n个构造器，则最多有 n - 1个构造器中使用了"this(形参列表)"  

- "this(形参列表)"必须声明在类的构造器的首行！

- 在类的一个构造器中，最多只能声明一个"this(形参列表)"

  