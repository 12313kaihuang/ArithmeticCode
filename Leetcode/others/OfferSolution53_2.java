package Leetcode.others;

public class OfferSolution53_2 {
    public int search3(int[] nums, int target) {
        int count = 0, pos = binarySearchFirst(nums, target);
        System.out.println(pos);
        if (pos >= 0) {
            while (pos < nums.length && nums[pos++] == target) count++;
        }
        return count;
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
