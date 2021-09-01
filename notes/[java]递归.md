# [java]递归 recursion

### 递归方法

一个方法调用它自身。

- 方法递归包含了一种隐式循环，它会重复执行某段代码，但这种重复执行无须循环控制。
- 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。



e.g. 1~100求和

```python
public int addition(int upperBound){
    if (upperBound == 1){
        return 1;
    }else{
        return upperBound+addition(upperBound-1);
    }
}
```

斐波那契数列

f(n) = f(n-1) + f(n-2)

可以考虑成走台阶的方法一共有多少种：一次只能跨一个台阶或者两个台阶，n阶
