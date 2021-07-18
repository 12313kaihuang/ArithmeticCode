package Leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewSolution10_02_2 {

    static int[] nums = new int[26];

    static {
        for (int i = 2, idx = 0; idx != 26; i++) {
            boolean ok = true;
            for (int j = 2; j <= i / j; j++) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) nums[idx++] = i;
        }
    }

    /**
     * 又换了一种key值生成算法
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci/solution/gong-shui-san-xie-tong-ji-bian-wei-ci-de-0iqe/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<String>> groupAnagrams(String[] ss) {
        List<List<String>> ans = new ArrayList<>();
        Map<Long, List<String>> map = new HashMap<>();
        for (String s : ss) {
            long cur = 1;
            for (char c : s.toCharArray()) {
                cur *= nums[c - 'a'];
            }
            List<String> list = map.getOrDefault(cur, new ArrayList<>());
            list.add(s);
            map.put(cur, list);
        }
        for (long key : map.keySet()) ans.add(map.get(key));
        return ans;
    }
}
