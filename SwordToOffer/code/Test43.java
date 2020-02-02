package ArithmeticCode.SwordToOffer.code;

import java.util.Arrays;

/**
 * 左旋转字符串
 */
public class Test43 {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        new Test43().LeftRotateString(str, 3);
    }

    /**
     * 可将字符串翻转三次得到结果
     * 如果 abcXYZdef  n = 3
     * 则 abcXYZdef -> fedXYZcba -> XYZdefcba -> XYZdefabc
     */
    public String LeftRotateString(String str, int n) {

        if (str == null || str.length() == 0) {
            return str;
        }

        int len = str.length();
        int mid = len - n;  //对应`d`的位置

        char[] chars = str.trim().toCharArray();

        //第一次旋转
        for (int i = 0; i < len / 2; i++) {
            swap(chars, i, len - i - 1);
        }

        //第二次旋转
        for (int i = 0; i < mid / 2; i++) {
            swap(chars, i, mid - i - 1);
        }

        //第三次旋转
        //for (int i = mid; i - mid < n / 2; i++) {
        //    swap(chars, i, len - (i - mid) - 1);
        //}
        //第二种旋转方法
        for (int i = mid, j = len - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
