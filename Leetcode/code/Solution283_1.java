package Leetcode.code;

import java.util.Arrays;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution283_1 {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (true) {
            while (i < n && nums[i] != 0) ++i; //第一个0的位置
            while (j < n && (j < i || nums[j] == 0)) ++j; //i后第一个非0的位置
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++; //这是要点？
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    //先覆盖后补0
    public void moveZeroes3(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        for (; right < n; right++) {
            if (nums[right] != 0) nums[left++] = nums[right];
        }
        for (; left < n; left++) nums[left] = 0;
    }

    public static void main(String[] args) {
        Solution283_1 solution283_1 = new Solution283_1();
        solution283_1.moveZeroes(new int[]{1, 0, 1});
        solution283_1.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
