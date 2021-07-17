package Leetcode.swordtooffer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OfferSolution53_1 {


    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int pos = binarySearch(nums, target);
        int count = pos >= 0 ? 1 : 0;
        if (count > 0) {
            int index = pos - 1;
            while (index >= 0 && nums[index--] == target) count++;
            index = pos + 1;
            while (index < nums.length && nums[index++] == target) count++;
        }
        return count;
    }

    //优化一下 index可以不用
    public int search2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int pos = binarySearch(nums, target);
        int count = 0;
        if (pos >= 0) {
            while (pos >= 0 && nums[pos] == target) {
                pos--;
                count++;
            }
            pos += (count + 1);
            while (pos < nums.length && nums[pos] == target) {
                pos++;
                count++;
            }
        }
        return count;
    }

    //二分查找
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        while (l <= r) {
            int mid = (l + r) / 2;
//            System.out.println("mid = " + mid + ", " + nums[mid]);
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }

}

