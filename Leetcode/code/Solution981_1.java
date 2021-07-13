package Leetcode.code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. 基于时间的键值存储
 * <p>
 * 创建一个基于时间的键值存储类TimeMap，它支持下面两个操作：
 * <p>
 * 1. set(string key, string value, int timestamp)
 * 存储键key、值value，以及给定的时间戳timestamp。
 * 2. get(string key, int timestamp)
 * 返回先前调用set(key, value, timestamp_prev)所存储的值，其中timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的timestamp_prev的那个值。
 * 如果没有值，则返回空字符串（""）。
 * <p>
 * 提示：
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在[1, 100]范围内。
 * 所有TimeMap.set操作中的时间戳timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和TimeMap.get函数在每个测试用例中将（组合）调用总计120000 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution981_1 {

    /**
     * 执行用时：
     * 122 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 111.1 MB, 在所有 Java 提交中击败了82.56%的用户
     */
    static class TimeMap {

        private final Map<String, List<Object[]>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            List<Object[]> list = map.getOrDefault(key, new ArrayList<>());
            list.add(new Object[]{value, timestamp});
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            List<Object[]> pairs = map.getOrDefault(key, new ArrayList<>());
            //从后往前  这里可以优化为二分查找
            int index = pairs.size() - 1;
            while (index >= 0 && ((int) pairs.get(index)[1] > timestamp)) index--;
            return index >= 0 ? (String) pairs.get(index)[0] : "";
        }
    }
}
