/**
 * 1818. 绝对差值和
 * <p>
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * <p>
 * 示例 2：
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * <p>
 * 示例 3：
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1818_1 {

    static int BASE = 1_000_000_007;

    //要想绝对差和足够小，则需要两个数组对应位置的数差值最小。
    //最多替换一个位置，所以先找差最大的位置，然后尝试将这个差降到最小
    //这个方法有问题  能将差值降到最小的不一定是最终能将差值降到最小的那一组，例如【1, 28, 21】，【9, 21, 20】
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int diff = 0, maxDiff = 0, maxDiffIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diff += d;
            if (d > maxDiff) {
                maxDiffIndex = i;
                maxDiff = d;
            }
        }

        //再次遍历  找到替换哪个元素能使差值最大的那个位置的新差达到最小
        int minDiff = maxDiff;
        for (int j : nums1) {
            int d = Math.abs(j - nums2[maxDiffIndex]);
            if (d < minDiff) minDiff = d;
        }
        diff %= BASE;
        System.out.println("替换" + nums1[maxDiffIndex] + "," + minDiff);
        return diff - maxDiff + minDiff;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1818_1().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
//        System.out.println(new Solution1818_1().minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4}));
        System.out.println(new Solution1818_1().minAbsoluteSumDiff(new int[]{1, 28, 21}, new int[]{9, 21, 20}));
    }
}
