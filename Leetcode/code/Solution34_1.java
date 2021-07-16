package Leetcode.code;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution34_1 {

    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearchFirst(nums, target);
        int[] res = new int[]{pos, pos};
        if (pos >= 0) {
            while (++pos < nums.length && nums[pos] == target)res[1]++;
        }
        return res;
    }

    //二分查找 找第一个目标元素的位置
    private int binarySearchFirst(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        if (nums[l] == target) return l;
        if (nums[r] == target && r > 0 && nums[r - 1] != target) return r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else {
                if (mid > 0 && nums[mid - 1] == target) r = mid - 1;
                else return mid;
            }
        }
        return -1;
    }
}

