package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 * <p>
 * 给出第一个词first 和第二个词second，考虑在某些文本text中可能以 "first second third" 形式出现的情况，
 * 其中second紧随first出现，third紧随second出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * <p>
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * <p>
 * 提示：
 * 1 <= text.length <= 1000
 * text由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和second由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1078_1 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        int f = 0, s = 1;
        while (s < words.length) {
            if (words[f].equals(first) && words[s].equals(second) && s < words.length - 1)
                ans.add(words[s + 1]);
            f++;
            s++;
        }
        return ans.toArray(new String[0]);
    }
}
