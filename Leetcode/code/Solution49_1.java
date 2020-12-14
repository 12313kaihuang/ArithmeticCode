
import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution49_1 {

    /**
     * 最笨的方法应该是构建哈希表，然后一个一个去判断，但是大概算了算这样很浪费空间啊。
     * 于是去偷瞄了两眼题解
     * 字符通过ASCII去存储的，所以也可以把它当成一个数字，所以可以先排序，然后再比较
     * <p>
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 29.93% 的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 36.20% 的用户
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> sorted = new ArrayList<>();
        //排序
        for (String s : strs) {
            char[] chars = s.toCharArray();
            quickSort(chars, 0, chars.length - 1);
            sorted.add(Arrays.toString(chars));
        }
        //存储
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < sorted.size(); i++) {
            String s = sorted.get(i);
            if (map.containsKey(s)) {
                result.get(map.get(s)).add(strs[i]);
            } else {
                map.put(s, result.size());
                int finalI = i;
                result.add(new ArrayList<String>() {{
                    add(strs[finalI]);
                }});
            }
        }
        return result;
    }

    /**
     * 官方题解
     * 直接使用的排序后的串做索引，内存上面感觉也没多少提升
     * <p>
     * 执行用时：7 ms, 在所有 Java 提交中击败了95.84%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了66.16%的用户
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private void quickSort(char[] chars, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        int provit = chars[(left + right) / 2];
        while (left <= right) {
            while (left <= right && chars[left] < provit) left++;
            while (left <= right && chars[right] > provit) right--;
            if (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(chars, start, right);
        quickSort(chars, left, end);
    }


    public static void main(String[] args) {
        //System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
        System.out.println(new Solution49_1().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
