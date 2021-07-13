package Leetcode.code;


/**
 * 9. 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 示例 4：
 * 输入：x = -101
 * 输出：false
 * <p>
 * 提示：
 * -231<= x <= 231- 1
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9_1 {

    //传统解法
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] chars = String.valueOf(x).toCharArray();
        int i = 0, j = chars.length - 1;
//        System.out.println(i + "," + j);
        while (i < j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    //不转字符串，倒着组装数，然后判断新数与原数是否一致
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int temp = x, revert = 0;
        while (temp > 0) {
            revert = revert * 10 + temp % 10;
            temp /= 10;
        }
        return revert == x;
    }


    /**
     * 优化
     * 1. 特殊数过滤
     * 2. 只翻转一半
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isPalindrome3(int x) {
        //小于0或者末尾是0且大于0的数不会是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revertedNumber = 0;
        //只翻转一半
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为偶数时，x == revertedNumber
        // 长度为奇数时，revertedNumber会多加一位，判断x == revertedNumber / 10
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9_1().isPalindrome2(121));
        System.out.println(new Solution9_1().isPalindrome2(-121));
        System.out.println(new Solution9_1().isPalindrome2(10));
        System.out.println(new Solution9_1().isPalindrome2(-101));
    }
}
