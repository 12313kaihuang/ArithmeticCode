package Leetcode.code;


/**
 * 1846. 减小和重新排列数组后的最大元素
 * <p>
 * 给你一个正整数数组arr。请你对 arr执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * <p>
 * arr中 第一个元素必须为1。
 * 任意相邻两个元素的差的绝对值 小于等于1，也就是说，对于任意的 1 <= i < arr.length（数组下标从 0 开始），
 * 都满足abs(arr[i] - arr[i - 1]) <= 1。abs(x)为x的绝对值。
 * 你可以执行以下 2 种操作任意次：
 * 减小 arr中任意元素的值，使其变为一个 更小的正整数。
 * 重新排列arr中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr中可能的 最大值。
 * <p>
 * 示例 1：
 * 输入：arr = [2,2,1,2,1]
 * 输出：2
 * 解释：
 * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
 * arr 中最大元素为 2 。
 * <p>
 * 示例 2：
 * 输入：arr = [100,1,1000]
 * 输出：3
 * 解释：
 * 一个可行的方案如下：
 * 1. 重新排列 arr 得到 [1,100,1000] 。
 * 2. 将第二个元素减小为 2 。
 * 3. 将第三个元素减小为 3 。
 * 现在 arr = [1,2,3] ，满足所有条件。
 * arr 中最大元素为 3 。
 * <p>
 * 示例 3：
 * 输入：arr = [1,2,3,4,5]
 * 输出：5
 * 解释：数组已经满足所有条件，最大元素为 5 。
 * <p>
 * 提示：
 * 1 <= arr.length <= 105
 * 1 <= arr[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1846_1 {

    /**
     * 只能减小数字且首个数字需要是1
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//        Arrays.sort(arr);
        quickSort(arr, 0, arr.length - 1);
        arr[0] = 1;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            //只能减小数字且首个数字需要是1 感觉可以这么做但是说不出原因 = =
            if (arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;
//            arr[i] = Math.min(arr[i], arr[i - 1] + 1);  排序+贪心
        }
        return arr[len - 1];
    }

    /**
     * 计数排序➕贪心
     * <p>
     * 记 arr 的长度为 n。由于第一个元素必须为 1，且任意两个相邻元素的差的绝对值小于等于 1，
     * 故答案不会超过 n。所以我们只需要对 arr 中值不超过 n 的元素进行计数排序，而对于值超过 n 的元素，
     * 由于其至少要减小到 n，我们可以将其视作 n。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/solution/jian-xiao-he-zhong-xin-pai-lie-shu-zu-ho-mzee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1]; ///cnt[n]代表数组中值为n到数到个数，大于n到计作n
        for (int v : arr) {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;  //计算缺失的数到值
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) ++miss;
            else
                //这一句是精华
                miss -= Math.min(cnt[i] - 1, miss); // miss 不会小于 0，故至多减去 miss 个元素
        }
        return n - miss;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int prev = arr[(start + end) / 2];
        int l = start, r = end;
        while (l <= r) {
            while (l <= r && arr[l] < prev) l++;
            while (l <= r && arr[r] > prev) r--;
            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        quickSort(arr, start, r);
        quickSort(arr, l, end);
    }
}
