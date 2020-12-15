
/**
 * 738. 单调递增的数字
 * <p>
 * 给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution738_1 {

    /**
     * 官方题解，贪心
     * 看题解可能不好理解，但是跟着代码来一遍就能理解了，其实就是我们去找这个数时的思路。
     * 但是自己想的话又感觉是想不出来的。。可能还是抽象能力不足吧。
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了97.96%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了69.67%的用户
     */
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        //找到第一个i 满足chars[i] < chars[i-1]
        while (i < strN.length && strN[i - 1] <= strN[i]) i++;
        if (i < strN.length) {
            //让chars[i] >= chars[i-1]，且前面的数也仍要保持规则，这里是精髓
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1]--;
                i--;
            }
            //此时i后面低位补9
            for (i += 1; i < strN.length; i++) strN[i] = '9';
        }
        return Integer.parseInt(new String(strN));
    }


    public static void main(String[] args) {
        System.out.println(new Solution738_1().monotoneIncreasingDigits(10));
        System.out.println(new Solution738_1().monotoneIncreasingDigits(1234));
        System.out.println(new Solution738_1().monotoneIncreasingDigits(332));
    }
}
