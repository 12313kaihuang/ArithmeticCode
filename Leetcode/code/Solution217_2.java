import java.util.Arrays;

public class Solution217_2 {

    /**
     * 快速排序,顺便复习一下
     */
    public boolean containsDuplicate(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        //System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }

    //[start,end]
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left, r = right;
        int pivot = nums[(left + right) / 2];
        while (l <= r) {
            //找到左边第一个大于pivot的数的位置
            while (l <= r && nums[l] < pivot) l++;
            //找到邮编第一个小于pivot的数的位置
            while (l <= r && nums[r] > pivot) r--;
            if (l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        quickSort(nums, left, r);
        quickSort(nums, l, right);
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
        System.out.println(new Solution217_2().containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution217_2().containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution217_2().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
