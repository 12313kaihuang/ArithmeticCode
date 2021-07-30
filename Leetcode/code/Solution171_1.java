package Leetcode.code;

/**
 * 171. Excel表列序号
 * <p>
 * 给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * <p>
 * 例如，
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 * <p>
 * 示例2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 * <p>
 * 示例3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * 示例 4:
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 * <p>
 * <p>
 * 提示：
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution171_1 {

    /**
     * 可以当成一个特殊的27进制字符串转10进制数，且不会溢出
     */
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0, base = 1;
        //从后向前加
        for (int i = len - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return res;
    }

    //从前向后处理
    public int titleToNumber2(String columnTitle) {
        int res = 0, len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            if (i > 0) res *= 26;  //移位
            res += (columnTitle.charAt(i) - 'A' + 1); //加上值
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution171_1().titleToNumber("A"));
        System.out.println(new Solution171_1().titleToNumber("AB"));
        System.out.println(new Solution171_1().titleToNumber2("ZY"));
    }
}
