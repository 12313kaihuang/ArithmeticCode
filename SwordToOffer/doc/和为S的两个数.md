# 和为S的两个数
## 题目描述
输入一个**递增排序的数组**和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
## 输出描述
> 对应每个测试案例，输出两个数，小的先输出。
## 解题思路
[讨论区](https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b?f=discussion)**马克Mark**的思路，也可以直接去讨论区看，下面是结合之后自己的理解和证明方式：<br/>
**从数组的两边开始**，因为数组是递增排序找到的**第一组和为S的**的两个数就是**乘积最小的**。<br/>
从两边开始找实现方式很好理解，下面来证明一下为什么第一组数就是乘积最小的：<br/>
假设找到的和为`S`的第一组数中，`x`是左边的数，`y`是右边的数，则`x + y = S`,`y` > `x`。这时存在两种情况：<br/>
* 只有这一组满足条件的数，那么直接返回`x`,`y`即可。
* 还有其他满足条件的一组或多组数，设其中的某一组数**左边的是`m`,右边的是`n`**，则有：
   ```
    1. x < m < n < y
    2. 设m = x + d,则n = y - d , d >= 1
    3. 由1,2可知：x < x + d < y - d < y  => y > x + d
    4. m * n = (x + d) * (y - d) = xy - dx + dy - d^2 = xy + d * (y - (x + d))
    5. 第3步得出y > x + d  所以可得 m * n > x * y的
    6. 综上可得此时的x,y是和为S且乘积最小的一组数。
   ```
### 思路一：
```java
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0, hight = array.length - 1;
        while (hight > low) {
            int curSum = array[low] + array[hight];
            if (curSum == sum) {
                //从两边开始  相差最远的两个数乘积最小
                result.add(array[low]);
                result.add(array[hight]);
                return result;
            } else if (curSum < sum) {
                low++;
            } else {
                hight--;
            }
        }
        return result;
    }
}
```

## Code
[code](../code/Test5.java)<br/>