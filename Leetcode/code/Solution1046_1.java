package Leetcode.code;

import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * <p>
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1046_1 {

    /**
     * 先用最笨的办法 每次粉碎完重新排序
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：35.7 MB , 在所有 Java 提交中击败了 83.29% 的用户
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        //此时len>=2
        bubbleSort(stones);
        while (stones[1] != 0) {
            System.out.println(Arrays.toString(stones));
            stones[0] -= stones[1];
            stones[1] -= stones[1];
            bubbleSort(stones);
        }
        return stones[0];
    }

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

    public static void main(String[] args) {
        System.out.println(new Solution1046_1().lastStoneWeight(new int[]{8, 7, 4, 1, 2, 1}));//5
        //System.out.println(new Solution1046_1().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));//5
    }
}



