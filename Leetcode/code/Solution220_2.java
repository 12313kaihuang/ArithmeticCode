package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 官方题解2 桶排序
     * <p>
     * 我们也可以使用利用桶排序的思想解决本题。我们按照元素的大小进行分桶，维护一个滑动窗口内的元素对应的元素。
     * 对于元素 xx，其影响的区间为 [x - t, x + t][x−t,x+t]。于是我们可以设定桶的大小为 t + 1t+1。
     * 如果两个元素同属一个桶，那么这两个元素必然符合条件。如果两个元素属于相邻桶，那么我们需要校验这两个
     * 元素是否差值不超过 tt。如果两个元素既不属于同一个桶，也不属于相邻桶，那么这两个元素必然不符合条件。
     * 具体地，我们遍历该序列，假设当前遍历到元素 xx，那么我们首先检查 xx 所属于的桶是否已经存在元素，
     * 如果存在，那么我们就找到了一对符合条件的元素，否则我们继续检查两个相邻的桶内是否存在符合条件的元素。
     * 实现方面，我们将 \texttt{int}int 范围内的每一个整数 xx 表示为
     * x = (t + 1) \times a + b(0 \leq b \leq t)x=(t+1)×a+b(0≤b≤t) 的形式，
     * 这样 xx 即归属于编号为 aa 的桶。因为一个桶内至多只会有一个元素，所以我们使用哈希表实现即可。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii/solution/cun-zai-zhong-fu-yuan-su-iii-by-leetcode-bbkt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
