package Leetcode.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums[i] = nums[j]，
 * 并且 i 和 j的差的 绝对值 至多为 k。
 * <p>
 * 示例1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution219_1 {

    //滑动窗口
    //两个循环的初始值和结束值还是有点东西
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numsSet = new HashSet<>();
        //差值为k，那么实际共k+1个元素
        for (int i = 0; i <= k && i < nums.length; i++) {
            System.out.println(numsSet + "," + nums[i]);
            if (numsSet.contains(nums[i])) return true;
            else numsSet.add(nums[i]);
        }
        for (int i = k + 1; i < nums.length; i++) {
            //现在遍历到i这里了，但是set中已经存在k个元素，所以需要先把最先加入到那个删除掉
//            System.out.println(numsSet + ", " + nums[i] + "， " + nums[i - k -1]);
            numsSet.remove(nums[i - k - 1]);
            if (numsSet.contains(nums[i])) return true;
            else numsSet.add(nums[i]);
        }
        return false;
    }

    /**
     * 一次遍历就够了
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.add(nums[i])) return true;
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }

    //虽然看上去代码少了 但是耗时更长 = =
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = indexMap.getOrDefault(nums[i], i);
            //可以确定i>=index的
            if (index != i && i - index <= k) return true;
            indexMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution219_1().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(new Solution219_1().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
