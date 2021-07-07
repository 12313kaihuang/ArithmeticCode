package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

public class Solution1711_2 {

    /**
     * 官方题解，相当于是反着来的
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-good-meals/solution/da-can-ji-shu-by-leetcode-solution-fvg9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0; //找出数组中最大值
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2; //和最大也不超过这个数
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //这个循环设计的也很巧妙，自己应该是想不出来
        for (int val : deliciousness) {
            //找出小于maxSum的所有的2的幂
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                //找到与之和为该2的幂的那个数的个数 在前面的数是找不到的，但是后面的数会再来一遍这时就有用了
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1); //本数个数+1
        }
        return pairs;
    }

}
