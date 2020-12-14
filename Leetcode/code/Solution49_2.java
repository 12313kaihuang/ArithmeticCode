import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49_2 {

    /**
     * 官方题解的第二种方式
     * 由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，
     * 故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
     * <p>
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 2626 的数组记录每个字母出现的次数。
     * 需要注意的是，在使用数组作为哈希表的键时，不同语言的支持程度不同，因此不同语言的实现方式也不同。
     * <p>
     * 执行用时：11 ms, 在所有 Java 提交中击败了34.94%的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了6.95%的用户
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        System.out.println(new Solution49_2().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
