package Leetcode.code;

@SuppressWarnings("unused")
public class Solution1877_2 {


    static int MAX = 100_000;

    //计数排序
    //参考 https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/solution/ji-shu-pai-xu-by-seiei-h2ng/
    public int minPairSum(int[] nums) {
        int[] arr = new int[MAX + 1];
        for (int num : nums) arr[num]++;
        int l = 0, r = MAX, maxSum = 0;
        while (l <= r) {  //这里l可以等于r
            if (arr[l] == 0) l++;
            else if (arr[r] == 0) r--;
            else {
                arr[l]--;
                arr[r]--;
                maxSum = Math.max(maxSum, l + r);
            }
        }
        return maxSum;
    }
}
