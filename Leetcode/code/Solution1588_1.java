package Leetcode.code;

import java.util.Arrays;

/**
 * 1588. 所有奇数长度子数组的和
 * <p>
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和 。
 * <p>
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * <p>
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1588_1 {

    //朴素解法 计算每个数的累加次数然后计算结果
    public int sumOddLengthSubarrays(int[] arr) {
        int[] count = new int[arr.length];
        for (int c = 1; c <= arr.length; c += 2) {
            for (int s = 0; s + c <= arr.length; s++) {
//                System.out.println("add " + s + " to " + (s + c - 1));
                for (int i = s; i < s + c; i++) count[i]++;
            }
        }
        System.out.println(Arrays.toString(count));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] * count[i]);
        }
        System.gc();
        return sum;
    }

    /**
     * 前缀和 将复杂度减少为O(n^2)
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/gong-shui-san-xie-yi-ti-shuang-jie-qian-18jq3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1]; //用于计算区间sum
        //sum[i]表示前i个数的和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int ans = 0;
        for (int len = 1; len <= n; len += 2) {
            for (int start = 0; start + len <= n; start++) {
                int end = start + len; //这里没有-1是因为sum的特性所致
                ans += (sum[end] - sum[start]);
            }
        }
        return ans;
    }

    /**
     * 数学计算
     * <p>
     * arr[i] 作为某个奇数子数组的成员的充要条件为：其所在奇数子数组左右两边元素个数奇偶性相同。
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/gong-shui-san-xie-yi-ti-shuang-jie-qian-18jq3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int sumOddLengthSubarrays3(int[] arr) {
        int ans = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            //示例i=0，n=5
            int l1 = (i + 1) >> 1;// i左侧连续子数组中长度为奇数的子数组个数
            int r1 = (n - i) >> 1; // i右侧连续子数组中长度为奇数的子数组个数
            int l2 = i >> 1; // i左侧连续子数组中长度为偶数的子数组个数
            int r2 = (n - i - 1) >> 1;// i右侧连续子数组中长度为偶数的子数组个数
            l2++;
            r2++; //因为单个数也算，所以这里自增1
            ans += (l1 * r1 + l2 * r2) * arr[i];
        }
        return ans;
    }

}
