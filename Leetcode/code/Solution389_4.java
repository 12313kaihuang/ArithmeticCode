package Leetcode.code;

public class Solution389_4 {

    /**
     * 官方题解 - 位运算
     * <p>
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
     * 类似于「136. 只出现一次的数字」，我们使用位运算的技巧解决本题。
     * <p>
     * a ^ a = 0
     * 0 ^ a = a
     */
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) result ^= c;
        for (char c : t.toCharArray()) result ^= c;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution389_4().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution389_4().findTheDifference("", "y"));
        System.out.println(new Solution389_4().findTheDifference("a", "aa"));
        System.out.println(new Solution389_4().findTheDifference("ae", "aea"));
    }
}
