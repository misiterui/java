# [java]方法参数的值传递机制

方法，必须由其所在类或对象调用才有意义。  

若方法含有参数：

- 形参：方法声明时的参数
- 实参： 方法调用时实际传给形参的参数值



### Java的实参值如何传入方法？

Java里方法的参数传递方式只有一种： 值传递。 即将实际参数值的副本（复制品）传入方法内，而参数本身不受影响。

- 形参是基本数据类型：将实参基本数据类型变量的“数据值”传递给形参
- 形参是引用数据类型：将实参引用数据类型变量的“地址值”传递给形参  

```java
// 以下情况，o1和o2里的值一起变，因为这俩指向堆空间中的同一个对象实体
Order o1 = new Order();
o1.orderId = 1001;
o2.orderId = o1;
```

```java
public class test {
    public static void main(String[] args) {
        Order o1 = new Order();
        System.out.println("o1.orderId = " + o1.orderId);
        o1.orderId = 1001;

        Order o2 = o1;

        System.out.println("o1.orderId = " + o1.orderId);
        System.out.println("o2.orderId = " + o2.orderId);

        o2.orderId = 1002;
        System.out.println("o1.orderId = " + o1.orderId);
        System.out.println("o2.orderId = " + o2.orderId);
    }

}

class Order{
    int orderId;
}

/* 输出
o1.orderId = 0
o1.orderId = 1001
o2.orderId = 1001
o1.orderId = 1002
o2.orderId = 1002
*/
```





### swap()

对象里的值交换

```java
public static void main(String[] args) {
    SwapTest test = new SwapTest();

    Data data = new Data();
    data.m=1;
    data.n=2;
    test.swap(data);
    System.out.println("data.m=" + data.m + ", data.n=" + data.n);
}
public void swap(Data data){
    data.m = data.m ^ data.n;
    data.n = data.m ^ data.n;
    data.m = data.m ^ data.n;
}


class Data{
    int m;
    int n;
}
```



数组中的值交换

```java
public static void main(String[] args) {
    int[] arr = new int[]{32,34,32,5,3,54,654,-98,0,-53,5};
    OverLoadTest test = new OverLoadTest();
    test.swap(arr, 0, 1);
    System.out.println("m=" + arr[0] + ", n=" + arr[1]);
}
public void swap(int[] arr, int m, int n){
    arr[m] = arr[m] ^ arr[n];
    arr[n] = arr[m] ^ arr[n];
    arr[m] = arr[m] ^ arr[n];
}
```



