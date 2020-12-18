package Leetcode.code;

public class Solution389_3 {

    /**
     * 官方题解 - 求和
     * <p>
     * 利用差值得到添加的字符
     */
    public char findTheDifference(String s, String t) {
        char result = 0;
        //这样内存占用小一些 但是耗时会变长
        for (int i = 0; i < t.length(); i++) result += t.charAt(i);
        for (int i = 0; i < s.length(); i++) result -= s.charAt(i);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution389_3().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution389_3().findTheDifference("", "y"));
        System.out.println(new Solution389_3().findTheDifference("a", "aa"));
        System.out.println(new Solution389_3().findTheDifference("ae", "aea"));
    }
}
