package ArithmeticCode.SwordToOffer.code;


import java.io.UncheckedIOException;

/**
 * Created by Hy on 2020/01/11 10:35
 * 数字在排序数组中出现的次数.md
 */
public class Test36 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(new Test36().GetNumberOfK1(array, 3));
    }

    //暴力遍历
    public int GetNumberOfK(int[] array, int k) {
        int index = 0;
        while (index < array.length && array[index] != k) {
            index++;
        }
        if (index >= array.length) {
            return 0;
        }
        int count = 1;
        for (int i = index + 1; i < array.length && array[i] == k; i++) {
            count++;
        }
        return count;
    }

    public int GetNumberOfK1(int[] array, int k) {
        //这个index只是找到了其中的一个
        int index = binarySearch(array, k);
        if (index == -1) {
            return 0;
        }
        int count = 1;
        //找到index前面是否还有相同的数
        for (int i = index + 1; i < array.length && array[i] == k; i++) {
            count++;
        }
        //找index后面是否还有相同的数
        for (int i = index - 1; i > 0 && array[i] == k; i--) {
            count++;
        }
        return count;
    }

    private int binarySearch(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (array[start] == k) {
            return start;
        } else if (array[end] == k) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == k) {
            return mid;
        } else if (array[mid] > k) {
            return binarySearch(array, k, start, mid - 1);
        } else {
            return binarySearch(array, k, mid + 1, end);
        }
    }

    //二分非递归
    private int binarySearch(int[] array, int k) {
        int start = 0, end = array.length - 1;
        if (array.length == 0) {
            return -1;
        }
        if (array[start] == k) {
            return start;
        }
        if (array[end] == k) {
            return end;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
