package Leetcode.code;

import java.util.Arrays;

public class Solution389_2 {

    /**
     * 用数组存
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 31.35% 的用户
     */
    public char findTheDifference(String s, String t) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        for (char c : s.toCharArray()) counts[c - 'a']++;
        for (char c : t.toCharArray()) if (counts[c - 'a']-- == 0) return c;
        throw new IllegalArgumentException("Parameter is wrong");
    }

    public static void main(String[] args) {
        System.out.println(new Solution389_2().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution389_2().findTheDifference("", "y"));
        System.out.println(new Solution389_2().findTheDifference("a", "aa"));
        System.out.println(new Solution389_2().findTheDifference("ae", "aea"));
    }
}
