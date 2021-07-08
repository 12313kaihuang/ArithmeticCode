package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * <p>
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1  //这是一个很重要的信息
 * 0 <= goal <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution930_1 {

    /**
     * 暴力解法估计也会超时
     * <p>
     * 核心点有两个：非空连续子数组；nums[i]非0即1
     * <p>
     * 用哈希表记录每一种前缀和出现的次数，假设我们当前枚举到元素 nums[j]，我们只需要查询
     * 哈希表中元素 sum[j]−goal 的数量即可，这些元素的数量即对应了以当前 j 值为右边界的
     * 满足条件的子数组的数量。最后这些元素的总数量即为所有和为 goal 的子数组数量。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/he-xiang-tong-de-er-yuan-zi-shu-zu-by-le-5caf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        //[1,0,1,0,1] goal=2
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1); //截止到num，和为sum的
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);  //这里看不懂是为啥？
        }
        return ret;
    }

    /**
     * 双指针，这个更不明所以了 = =
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/gong-shui-san-xie-yi-ti-shuang-jie-qian-hfoc0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numSubarraysWithSum2(int[] nums, int t) {
        int n = nums.length;
        int ans = 0;
        for (int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > t) s1 -= nums[l1++];
            while (l2 <= r && s2 >= t) s2 -= nums[l2++];
            ans += l2 - l1;
        }
        return ans;
    }

    /**
     * 滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/he-xiang-tong-de-er-yuan-zi-shu-zu-by-le-5caf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numSubarraysWithSum3(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }
}
