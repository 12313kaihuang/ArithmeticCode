package Leetcode.code;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * <p>
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * 注意:
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution611_1 {

    /**
     * 要想能成三角形，那么需要a + b > c, a + c > b, b + c > a.
     * 先排序数组，然后从前向后遍历，那么就一定有a + c > b, b + c > a，
     * 这时只需判断a + b > c
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-triangle-number/solution/you-xiao-san-jiao-xing-de-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) { //a
            int k = i + 2; //c
            //nums[i] != 0 这个判断很重要
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {  //b
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += (k - j);
            }
        }
        return count;
    }

    /**
     * @return 找出边界范围内小于target的值的最大下标
     */
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
//        System.out.println(Arrays.toString(nums) + "," + target + ", " + left);
        //此时可以保证nums[left] >= target
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution611_1().triangleNumber(new int[]{2, 2, 3, 4}));
    }

    /**
     * 我们使用一重循环枚举 i。j 的初始值为 i + 1，k 的初始值为 j + 1 = i + 2。
     * 对于每个固定的 j，我们增加 k 的值，直到有 nums[i] + nums[j] > nums[k]，
     * 此时 nums[j + 1] 到 nums[k - 1] 都满足条件，因此给答案加上 k - j - 1。
     * 随后我们将 j 的值增加 1，但 k 不用从 j + 1 开始增加，而是从上一次的 k 开始增加即可。
     * 这样做的正确性在方法二中也有所表述，因为如果 nums[i] + nums[j] > nums[k] 成立，
     * 那么满足 nums[i] + nums[j + 1] > nums[k1 + 1] 条件的 k1 一定不小于 k。
     * 在每一次循环中，我们只会将 j 和 k 增加 O(N)O(N) 次，
     * 因此时间复杂度为 O(N^2)。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-triangle-number/solution/you-xiao-san-jiao-xing-de-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int triangleNumber2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }


}
