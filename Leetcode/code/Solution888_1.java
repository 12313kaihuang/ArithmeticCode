package Leetcode.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * 888. 公平的糖果棒交换
 * <p>
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，
 * B[j] 是鲍勃拥有的第 j 根糖果棒的大小。因为他们是朋友，所以他们想交换一根糖果棒，
 * 这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1]是 Bob
 * 必须交换的糖果棒的大小。如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * <p>
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution888_1 {

    /**
     * 官方题解：
     * 先计算差值，然后遍历寻找满足差值的两个数。
     * 使用哈希表是一个优化点
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        //因为一定存在答案，交换是你加我减的操作，所以差值一定是2的倍数
        int diff = (sumA - sumB) / 2;
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(A).forEach(set::add);
        for (int num : B) {
            int target = num + diff;
            if (set.contains(target)) {
                res[0] = target;
                res[1] = num;
                return res;
            }
        }
        return res;
    }
}
