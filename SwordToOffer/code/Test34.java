package ArithmeticCode.SwordToOffer.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hy on 2020/01/09 10:35
 * <p>
 * 第一次只出现一次的字符.md
 */
public class Test34 {

    //利用map暴力破解
    public int FirstNotRepeatingChar2(String str) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        //遍历并存储出现次数
        for (Character c : str.toCharArray()) {
            if (charMap.containsKey(c)) {
                Integer integer = charMap.get(c);
                charMap.put(c, integer + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        //再次遍历找到出现次数为1的字符
        for (Character c : str.toCharArray()) {
            if (charMap.get(c) == 1) {
                return str.indexOf(c);
            }
        }

        return -1;
    }

    //自己构建hash表存储出现次数
    // 根据题意 应该都是普通字符，即a-z A-Z 0 - 9
    //对应ASCII为97-122 65-90 48-57
    public int FirstNotRepeatingChar(String str) {
        //申请二维数组以存储出现次数，对应下标计算方法为ASCII - ‘0’
        int[][] appearNums = new int['z' - '0' + 1][1];

        //遍历并计算出现次数
        for (Character c : str.toCharArray()) {
            appearNums[c - '0'][0]++;
        }

        for (int index = 0; index < str.length(); index++) {
            char c = str.charAt(index);
            if (appearNums[c - '0'][0] == 1){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Test34().FirstNotRepeatingChar("google"));
    }
}
