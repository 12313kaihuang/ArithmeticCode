package Leetcode.code;


/**
 * 520. 检测大写字母
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution520_1 {

    public boolean detectCapitalUse(String word) {
        int length = word.length();
        boolean firstUpper = word.charAt(0) < 'a';
        int upperCount = 0;
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) < 'a') upperCount++;
        }
        return firstUpper ? (upperCount == 1 || upperCount == length) : upperCount == 0;
    }

    /**
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/detect-capital/solution/gong-shui-san-xie-jian-dan-zi-fu-chuan-m-rpor/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean detectCapitalUse2(String word) {
        if (word.toUpperCase().equals(word)) return true;
        if (word.toLowerCase().equals(word)) return true;
        int n = word.length(), idx = 1;
        if (Character.isUpperCase(word.charAt(0))) {
            while (idx < n && Character.isLowerCase(word.charAt(idx))) idx++;
        }
        return idx == n;
    }


}
