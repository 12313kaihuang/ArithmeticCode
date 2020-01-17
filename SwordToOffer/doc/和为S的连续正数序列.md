# 和为S的连续正数序列

## 题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

## 输出描述
输出所有和为S的**连续正数序列**。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
## 解题思路
双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。详见[讨论区](https://www.nowcoder.com/questionTerminal/c451a3fd84b64cb19485dad758a55ebe?f=discussion)
### 思路一：
```java
public class Solution {
    //由于是从连续正数序列中去找到满足条件的数  可以使用滑动窗口策略
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        //要求连续正数序列 则单个的如1 2 这样的不算，所以sum >= 3的。
        while (high > low) {
            //等差数列求和
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {
                //如果等于加入结果中
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                //low向右滑动
                low++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }
}
```


## Code
[code](../code/Test41.java)<br/>
