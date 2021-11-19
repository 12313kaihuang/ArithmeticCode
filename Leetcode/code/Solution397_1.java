package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * <p>
 * 给定一个正整数n ，你可以做如下操作：
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 * <p>
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * <p>
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution397_1 {

    /**
     * 数值太大会stackoverflower
     */
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) {
            return 1 + integerReplacement(n >> 1);
        } else {
            //当n=2^31 - 1时，n+1会溢出，所以2作出优化
            return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
        }
    }

    public int integerReplacement2(int n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) {
            return 1 + integerReplacement(n >> 1);
        } else {
            //这里的逻辑修改一下
            return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
        }
    }

    Map<Integer, Integer> map = new HashMap<>();

    //map优化去除重复计算
    public int integerReplacement3(int n) {
        if (n == 1) return 0;
        if (!map.containsKey(n)) {
            if ((n & 1) == 0) {
                map.put(n, 1 + integerReplacement(n >> 1));
            } else {
                //这里的逻辑修改一下
                map.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return map.get(n);
    }

    /**
     * 贪心
     * <p>
     * 为什么能想到除以4呢？？
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/integer-replacement/solution/zheng-shu-ti-huan-by-leetcode-solution-swef/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int integerReplacement4(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }
}
