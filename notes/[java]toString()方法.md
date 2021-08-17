# [java]toString()方法

toString()方法在Object类中定义， 其返回值是String类型， 返回类名和它的引用地址。  

在Object类中：

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

- 在进行String与其它类型数据的连接操作时， 自动调用toString()方法  

  ```java
  Date now=new Date();
  System.out.println(“now=”+now); 相当于
  System.out.println(“now=”+now.toString());
  ```

- 可以根据需要在用户自定义类型中重写toString()方法。如String 类重写了toString()方法， 返回字符串的值。  

  ```java
  s1=“hello”;
  System.out.println(s1);//相当于System.out.println(s1.toString());
  ```

- 基本类型数据转换为String类型时， 调用了对应包装类的toString()方法  

  ```java
  int a=10; System.out.println(“a=”+a);
  ```



### 重写toString()

```java
@Override
public String toString(){
    return "Customer[name = ]" + name + 
        ", age = " + age +"]";
}
```



### 面试题

```java
public void test() {
	char[] arr = new char[] { 'a', 'b', 'c' };
	System.out.println(arr);//abc
	int[] arr1 = new int[] { 1, 2, 3 };
	System.out.println(arr1);//[I@10f87f48
	double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
	System.out.println(arr2);//[D@b4c966a
}
```

