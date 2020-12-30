package common.sort;

@SuppressWarnings("unused")
public class BubbleSort {

    /**
     * 使用冒泡降序排序
     * <p>
     * 当数组基本有序时，优化的冒泡排序效率最高
     * <p>
     * 优化策略：
     * 1. 当某一轮比较中，没有交换过元素，则说明此时数组已经排序好了，没有必要在循环下去了
     * 2. 记录内层循环最后一个交换元素的位置，下次进入循环比较到这个位置就不用再往下比较了
     */
    private static void bubbleSort(int[] arr) {
        int k = arr.length - 1, pos = 0;
        for (int i = 0; i < arr.length - 1; i++) { //外层循环控制循环次数
            boolean swap = false; //优化外层循环，若没有交换过元素，则说明此时数组已经排序好了，没有必要在循环下去了
            for (int j = 0; j < k; j++) { //内层循环保证相邻两个数的位置
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                    pos = j; //记录本次循环最后一次交换的数的位置，及本次循环后，pos之后的数都是排好序的了
                }
            }
            k = pos;
            if (!swap) return;
        }
    }
}
