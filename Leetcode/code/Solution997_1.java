package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 997. 找到小镇的法官
 * <p>
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组trust，该数组由信任对 trust[i] = [a, b]组成，表示编号为 a 的人信任编号为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * <p>
 * 示例 4：
 * 输入：n = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust[i] 互不相同
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution997_1 {


    /**
     * 满足条件1、2即出度（不相信所有人）为0，入度（所有人相信他）为n-1
     */
    public int findJudge(int n, int[][] trust) {
        int[][] assist = new int[n + 1][2];
        for (int[] branch : trust) {
            assist[branch[0]][0]++;  //出度+1
            assist[branch[1]][1]++;  //入度+1
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (assist[i][0] == 0 && assist[i][1] == n - 1) ans.add(i);
        }
        return ans.size() == 1 ? ans.get(0) : -1;
    }

    //按照题解的意思，应该是不存在两个人同时满足条件1、2
    public int findJudge2(int n, int[][] trust) {
        int[] in = new int[n + 1], out = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            in[b]++;
            out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) return i;
        }
        return -1;
    }

}
