package Others.interview;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class ByteDanceTest2 {

    private List<String> res;

    public String[] permutation(String s) {
        res = new ArrayList<>();
        dfs(s.toCharArray(), 0);
        return res.toArray(new String[0]);
    }

    /**
     * @param x 固定字符数
     */
    private void dfs(char[] chars, int x) {
        System.out.printf("\ndfs %d\n" , x);
        if (x == chars.length - 1) {
            System.out.println("add " + new String(chars));
            res.add(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>(); //用于查重
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(chars, i, x);
            System.out.printf("交换 %d %d\n", i, x);
            dfs(chars, x + 1); //传入的是x+1
            swap(chars, i, x);
            System.out.printf("交换回来 %d %d\n", i, x);
        }
        System.out.println();
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ByteDanceTest2().permutation("abc")));
    }
}
