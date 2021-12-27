package Leetcode.code;

import java.util.Arrays;

/**
 * 825. 适龄的朋友
 * <p>
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * <p>
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 * <p>
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * 返回在该社交媒体网站上产生的好友请求总数。
 * <p>
 * 示例 1：
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * <p>
 * 示例 2：
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * <p>
 * 示例 3：
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 * <p>
 * 提示：
 * n == ages.length
 * 1 <= n <= 2 * 10^4
 * 1 <= ages[i] <= 120
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution825_1 {

    /**
     * 官方题解：排序+双指针
     * <p>
     * 当0.5×ages[x]+7 < ages[y] ≤ ages[x]，x会向y发送好友请求，
     * 所以当ages[x] <= 14时，不存在满足条件当y；
     * 使用双指针根据指定当x限定出对应y的区间即可得到对应x的y的个数；
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages/solution/gua-ling-de-peng-you-by-leetcode-solutio-v7yk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) continue;
            while (age * 0.5 + 7 >= ages[left]) left++;
//            while (ages[right] < age) right++;  //这样只能找到第一个=age的值的位置，而实际需要找到最后一个位置
            while (right + 1 < ages.length && ages[right + 1] <= age) right++;
            //此时ages[left]>x,ages[right]=x。因为x一定时在ages数组中的
            ans += right - left; //因为x一定在[left,right]区间中，所以个数需要减一
        }
        return ans;
    }

    /**
     * 官方题解2 计数排序+前缀和
     * ？？？？？
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages/solution/gua-ling-de-peng-you-by-leetcode-solutio-v7yk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numFriendRequests2(int[] ages) {
        int[] cnt = new int[121]; //cnt[i]表示i出现次数
        for (int age : ages) ++cnt[age]; //1 <= ages[i] <= 120
        int[] pre = new int[121]; //pre[i]为cnt的前缀和
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                //(pre[i] - pre[bound - 1] - 1); 为年龄为i的用户所发出的请求数
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }
}
