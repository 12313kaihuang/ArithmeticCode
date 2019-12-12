# 包含min函数的栈

## 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
## 解题思路
用两个栈来实现，以空间换时间。因为之前做过类似的题，所以这里就不写题解了。详见：[**实现一个栈，可获取栈内最大值**](Others/doc/实现一个栈，可获取栈内最大值.md)。
### 思路一：
```java
public class Solution {

    //用于存储数值
    private Stack<Integer> numStack = new Stack<>();
    //用于存储当前最小值
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        numStack.push(node);

        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            int currentMin = minStack.peek();
            minStack.push(Math.min(currentMin, node));
        }
    }

    public void pop() {
        numStack.pop();
        minStack.pop();
    }

    public int top() {
        return numStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
```


## Code
[code](../code/Test20.java)<br/>

## 相关扩展
* [**实现一个栈，可获取栈内最大值**](Others/doc/实现一个栈，可获取栈内最大值.md)
