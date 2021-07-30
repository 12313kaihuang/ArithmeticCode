package Leetcode.code;

/**
 * 168. Excel表列名称
 * <p>
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * <p>
 * 示例2:
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 示例3:
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution168_1 {

    /**
     * 类似于进制转换，把他当成一个特殊的26进制转换
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/excelbiao-lie-ming-cheng-by-leetcode-sol-hgj4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    /**
     * 从1开始的26进制转换
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/gong-shui-san-xie-cong-1-kai-shi-de-26-j-g2ur/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String convertToTitle2(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; //-1实现整体偏移
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution168_1().convertToTitle3(1));
        System.out.println(new Solution168_1().convertToTitle3(28));
        System.out.println(new Solution168_1().convertToTitle3(701));
    }


    public String convertToTitle3(int columnNumber) {
        int base = 26;
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; //-1之后对26求余才能得到[0-15]，除以26才能得到下一阶对应对正确的值
            int num = columnNumber % base;
            builder.append((char) (num + 'A'));
            columnNumber /= base;
        }
        return builder.reverse().toString();
    }
}
