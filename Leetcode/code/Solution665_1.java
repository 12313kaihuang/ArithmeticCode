package Leetcode.code;

/**
 * 665. 非递减数列
 * <p>
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution665_1 {

    //https://leetcode-cn.com/problems/non-decreasing-array/solution/3-zhang-dong-tu-bang-zhu-ni-li-jie-zhe-d-06gi/
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    //4 6 1 此时应将1改为6而不是将6改为1
                    nums[i] = nums[i - 1];
                } else {
                    //4 6 4 此时可将6改为4也可将4改为6
                    // 4 6 4 (5) 此时就只能将6改为4
                    nums[i - 1] = nums[i];
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution665_1().checkPossibility(new int[]{4, 2, 3}));
        System.out.println(new Solution665_1().checkPossibility(new int[]{4, 2, 1}));
        System.out.println(new Solution665_1().checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
