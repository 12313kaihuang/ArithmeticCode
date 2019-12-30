# 最小的k个数

## 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
## 解题思路
第一个思路简单粗暴，就是**先排序，再取值**，然后去逛了一下讨论区看看有没有高招，但是看到大多数答案也都是先排序，有些貌似用到了最大堆什么的，暂时不太清楚这个东西所以就没有细看，先[mark](https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf?f=discussion)一下。
### 思路一：
先从小到大进行**排序**，再从结果中取出相应的值。
```java
public class Solution {
    
    //先排序 再取值
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length) {
            return result;
        }
        //BubbleSort(input);
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    //冒泡排序
    private void BubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] += array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

    //快速排序
    //基准值选取 https://blog.csdn.net/qq_38289815/article/details/82718428
    private void quickSort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int base = array[start]; //基准值
        int i = start, j = end;
        int temp;
        do {
            //从前往后找到第一个大于base的值
            while (i < array.length && array[i] < base) {
                i++;
            }

            //从后往前找到第一个小于base的值
            while (j >= 0 && array[j] > base) {
                j--;
            }

            //交换
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

        } while (i <= j);

        //此时i > j
        if (j > start) {
            quickSort(array, start, j);
        }

        if (i < end) {
            quickSort(array, i, end);
        }

    }
}
```


## Code
[code](../code/Test29.java)<br/>


