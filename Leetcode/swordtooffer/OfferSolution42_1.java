package Leetcode.swordtooffer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OfferSolution42_1 {

    //贪心？
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = nums[0], max = sum;
        for (int i = 1; i < nums.length; i++) {
            int temp = sum + nums[i];
            //之所以加个max的原因是因为贪心贪到最后到值不一定是最大的
            //例如：[5, -4 , 3]，index到-4时还会继续贪下去，如果-4后面是3那么肯定
            //最终满足要求到字串不包含-4，但是若后面是5，那么最终字串可能就会包含-4了。
            if (temp > 0 && temp > nums[i]) sum += nums[i];
            else sum = nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 动态规划
     * <p>
     * 贪心无法解决i下一个数对最终结果对影响，那么就再加一个pre来辅助判断。
     * 总感觉上面对贪心有些运气的成分。
     * <p>
     * 跟着代码走一遍感觉跟上面解法有些相似点 = =
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new OfferSolution42_1().maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new OfferSolution42_1().maxSubArray2(new int[]{-2, -1}));
    }
}
