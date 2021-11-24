package Leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 423. 从英文中重建数字
 * <p>
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 * <p>
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution423_1 {

    private static final List<int[]> numArrayList = new ArrayList<>();

    static {
        numArrayList.add(getCharArray("zero"));
        numArrayList.add(getCharArray("one"));
        numArrayList.add(getCharArray("two"));
        numArrayList.add(getCharArray("three"));
        numArrayList.add(getCharArray("four"));
        numArrayList.add(getCharArray("five"));
        numArrayList.add(getCharArray("six"));
        numArrayList.add(getCharArray("seven"));
        numArrayList.add(getCharArray("eight"));
        numArrayList.add(getCharArray("nine"));
    }

    //统计每个字符出现的次数并返回
    private static int[] getCharArray(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        return array;
    }

    //模拟？ TODO 这个题解有问题
    //"zerozero"要求返回"00" 字符不能重复利用
    @Deprecated
    public String originalDigits(String s) {
        int[] charArray = getCharArray(s);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int[] arr = numArrayList.get(i);
            boolean ok = true;
            for (int j = 0; j < arr.length; j++) {
                if (charArray[j] < arr[j]) {
                    ok = false;
                    break;
                }
            }
            System.out.println(i + "," + ok);
            if (ok) builder.append(i);
        }
        return builder.toString();
    }

    /**
     * 文字游戏题？
     * s是一串数字的英文字母，打乱后的字符串，而'z'只在0中有，所以'z'有多少个，
     * 0就有多少个，以此类推。详见解析
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/solution/cong-ying-wen-zhong-zhong-jian-shu-zi-by-9g1r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String originalDigits2(String s) {
        Map<Character, Integer> c = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            ans.append(String.valueOf((char) (i + '0')).repeat(Math.max(0, cnt[i])));
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution423_1().originalDigits("zerozero"));
    }
}
