package Leetcode.code;

public class Solution28_2 {

    /**
     * KMP 算法
     * haystack: 原串(string)  needle: 匹配串(pattern)
     * <p>
     * next[i]代表什么意义？：匹配串从头到i位置含有的相同前后缀的最大长度
     * next数组如果创建：根据匹配串生成的，跟原串没有关系
     * 看KMP的话这个文章更清楚：https://leetcode-cn.com/problems/implement-strstr/solution/dai-ma-sui-xiang-lu-kmpsuan-fa-xiang-jie-mfbs/
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int resLen = haystack.length(), tarLen = needle.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        haystack = " " + haystack;
        needle = " " + needle;

        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[tarLen + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= tarLen; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && target[i] != target[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (target[i] == target[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= resLen; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && source[i] != target[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (source[i] == target[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == tarLen) return i - tarLen;
        }

        return -1;
    }
}
