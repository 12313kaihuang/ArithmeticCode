package Leetcode.code;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II
 * <p>
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * 1 <= n <= 1690
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution264_1 {

    /**
     * 官方题解 最小堆
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @SuppressWarnings("unused")
    public int nthUglyNumber(int n) {
        int[] base = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>(); //用于查重，用Long是为了避免溢出
        PriorityQueue<Long> queue = new PriorityQueue<>(); //最小堆
        set.add(1L);
        queue.offer(1L);
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur = queue.poll();  //每次poll返回当前最小的元素
            for (int b : base) {
                long next = cur * b;
                if (set.add(next)) queue.offer(next);
            }
        }
        return (int) cur;
    }


    /**
     * 官方题解 动态规划
     */
    public int nthUglyNumber2(int n) {
        if (n <= 1) return n;
        int p2 = 1, p3 = 1, p5 = 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            int t2 = res[p2] * 2;
            int t3 = res[p3] * 3;
            int t5 = res[p5] * 5;
            res[i] = Math.min(t2, Math.min(t3, t5));
            if (res[i] == 6) {
                System.out.println("666");
            }
            //注意这里需要并列判断，这样才能达到去重的效果
            if (t2 == res[i]) p2++;
            if (t3 == res[i]) p3++;
            if (t5 == res[i]) p5++;
        }
        System.out.println(Arrays.toString(res));
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution264_1().nthUglyNumber2(10));
    }
}
