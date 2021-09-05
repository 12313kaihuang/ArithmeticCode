package Leetcode.code;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * <p>
 * 已有方法rand7可生成 1 到 7 范围内的均匀随机整数，试写一个方法rand10生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的Math.random()方法。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: [7]
 * <p>
 * 示例 2:
 * 输入: 2
 * 输出: [8,4]
 * <p>
 * 示例 3:
 * 输入: 3
 * 输出: [8,1,10]
 * <p>
 * 提示:
 * rand7已定义。
 * 传入参数:n表示rand10的调用次数。
 * <p>
 * 进阶:
 * rand7()调用次数的期望值是多少?
 * 你能否尽量少调用 rand7() ?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution470_1 {

    /**
     * 官方题解1 拒绝采样
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/yong-rand7-shi-xian-rand10-by-leetcode-s-qbmd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }


    /**
     * 官方题解2
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/yong-rand7-shi-xian-rand10-by-leetcode-s-qbmd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int rand10_2() {
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 40) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 40;
            b = rand7();
            // get uniform dist from 1 - 63
            idx = b + (a - 1) * 7;
            if (idx <= 60) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 60;
            b = rand7();
            // get uniform dist from 1 - 21
            idx = b + (a - 1) * 7;
            if (idx <= 20) {
                return 1 + (idx - 1) % 10;
            }
        }
    }

    private int rand7() {
        return 0;
    }
}
