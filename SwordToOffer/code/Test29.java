package ArithmeticCode.SwordToOffer.code;

import java.util.ArrayList;

/**
 * Created by Hy on 2019/12/30 9:52
 * <p>
 * 最小的k个数.md
 */
public class Test29 {

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
