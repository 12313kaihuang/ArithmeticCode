package Leetcode.code;

/**
 * 1518. 换酒问题
 * <p>
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 * <p>
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 * <p>
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 * <p>
 * 示例 4：
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 * <p>
 * 提示：
 * 1 <=numBottles <= 100
 * 2 <=numExchange <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1518_1 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int more = numBottles / numExchange; //more >= 1
            ans += more;
            numBottles = numBottles % numExchange + more;
        }
        return ans;
    }

    public int numWaterBottles2(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            //每numExchange个瓶子可以换一瓶酒，同时喝完会多出一个空瓶子
            numBottles -= numExchange;
            ans++;
            numBottles++;
        }
        return ans;
    }

    /**
     * 数学计算
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/water-bottles/solution/huan-jiu-wen-ti-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numWaterBottles3(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }
}