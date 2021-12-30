package Leetcode.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846. 一手顺子
 * <p>
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，
 * 并且由 groupSize 张连续的牌组成。
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。
 * 如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * <p>
 * 示例 2：
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * 提示：
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution846_1 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : hand) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        for (int x : hand) {
            //尝试以x为起始数组成顺子
            if (!cnt.containsKey(x)) continue;
            for (int i = 0; i < groupSize; i++) {
                int k = x + i;
                if (!cnt.containsKey(k)) return false;
                int count = cnt.get(k);
                cnt.put(k, count - 1);
                if (count == 1) cnt.remove(k);
            }
        }
        return true;
    }
}
