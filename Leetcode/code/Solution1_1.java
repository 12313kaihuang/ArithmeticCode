package Leetcode.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1_1 {

    /**
     * 暴力遍历
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, temp = target - nums[i]; j < nums.length; j++) {
                if (nums[j] == temp) return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * 空间换时间
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null && i != j) return new int[]{i, j};
        }
        return null;
    }

    /**
     * 优化版
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
//                return new int[]{i, map.get(target - nums[i])};
                return new int[]{map.get(target - nums[i]), i};
            } //这样就避免了两个相同的值和为target的问题，如6 = 3 + 3
            map.put(nums[i], i);
        }
        return null;
    }

    //还可以先排序然后双指针
    public int[] twoSum4(int[] nums, int target) {
        int[] ori = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            System.out.println("i=" + i + ",j=" + j + ", " + (nums[i] + nums[j]));
            if (nums[i] + nums[j] > target) j--;
            else if (nums[i] + nums[j] < target) i++;
            else {
                //todo找位置并返回吧
            }
        }
        return null;
    }

    private int getIndex(int[] nums, int target) {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1_1().twoSum4(new int[]{3, 2, 4}, 6)));

    }
}
