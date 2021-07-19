package Others.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述：给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * <p>
 * 示例1:[2,3,4,5]  -- 4
 * 示例2:[2,2,3,4,3]  -- 3
 * 示例3:[1,2,3,1,2,3,2,2]  -- 3
 * 示例4:[9]  -- 1
 * 示例5:[2,2,3,4,8,99,3]  -- 5
 */
public class ByteDanceTest1 {
    //set+滑动窗口  复杂度O(n^2)
    public int maxNoRepeatChildNum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int max = 0, l = 0, r = 1;
        for (; r < nums.length; r++) {
            if (!set.add(nums[r])) {
                max = Math.max(max, r - l);
                while (nums[l++] != nums[r]) {
                    set.remove(nums[l - 1]);
                }
            }
        }
        //注意最后还要再取一次最大值
        return Math.max(max, r - l);
    }

    //改为map存储下标  复杂度降为O(n)
    public int maxNoRepeatChildNum2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, l = 0, r = 0;
        for (; r < nums.length; r++) {
            Integer index = map.getOrDefault(nums[r], -1);
            if (index >= 0 && index != r) {
                max = Math.max(max, r - l);
                l = index + 1;
            }
            map.put(nums[r], r);
        }
        //注意最后还要再取一次最大值
        return Math.max(max, r - l);
    }

    public static void main(String[] args) {
        System.out.println(new ByteDanceTest1().maxNoRepeatChildNum(new int[]{2, 3, 4, 5}));
        System.out.println(new ByteDanceTest1().maxNoRepeatChildNum2(new int[]{2, 2, 3, 4, 3}));
        System.out.println(new ByteDanceTest1().maxNoRepeatChildNum2(new int[]{1, 2, 3, 1, 2, 3, 2, 2}));
        System.out.println(new ByteDanceTest1().maxNoRepeatChildNum(new int[]{9}));
        System.out.println(new ByteDanceTest1().maxNoRepeatChildNum2(new int[]{2, 2, 3, 4, 8, 99, 3}));
    }
}
