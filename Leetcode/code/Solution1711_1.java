package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 1711. 大餐计数
 * <p>
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，
 * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * <p>
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1711_1 {


    //还是超出时间限制了  = =
    public int countPairs(int[] deliciousness) {
        int count = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if (check(deliciousness[i], deliciousness[j])) count++;
            }
        }
        return (count) % (int) (Math.pow(10, 9) + 7);
    }

    private Map<Long, Integer> mCacheMap = new HashMap<>();

    private boolean check(int a, int b) {
        long c = a + b, temp = c;
        Integer cache = mCacheMap.get(c);
        if (cache != null) return cache == 1;
        //如果是2的幂则2进制位中有且仅有1位是1
        int count = 0;
        while (c > 0) {
            if ((c & 1) == 1) count++;
            c = c >>> 1;
            if (count > 1) break;
        }
        mCacheMap.put(temp, count);
        return count == 1;
    }

    /**
     * success 149, 107
     * success 1, 63
     * success 1, 0
     * success 1, 1
     * success 63, 1
     * success 0, 1
     * success 6867, 1325
     * success 5611, 2581
     * success 39, 89
     * success 46, 18
     * success 12, 20
     * success 22, 234
     */

    public static void main(String[] args) {
//        System.out.println(new Solution1711_1().countPairs(new int[]{1,3,5,7,9}));
//        System.out.println(new Solution1711_1().countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println(new Solution1711_1().countPairs(new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234}));
//        System.out.println(new Solution1711_1().countPairs(new int[]{0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234}));
    }
}
