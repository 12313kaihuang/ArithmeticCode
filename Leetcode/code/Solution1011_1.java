package Leetcode.code;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * <p>
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * <p>
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1011_1 {

    /**
     * 官方题解
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/zai-d-tian-nei-song-da-bao-guo-de-neng-l-ntml/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int shipWithinDays(int[] weights, int D) {
        //首先找到可选的载货量的区间值
        //若D=weights.length，则每天运一个就可以了，这时可以取到最小的载货量为weights中最大值
        int min = Arrays.stream(weights).max().getAsInt();
        //当D=1时可以取到最大运载量为所有货物重量总和
        int max = Arrays.stream(weights).sum();

        //在D要求内采用二分查找找到能够达到要求的最小载货量即可
        while (min < max) {
            int mid = (min + max) / 2;
            int days = 1;  //所需天数
            int sum = 0;   //当前这一天的载货总量
            for (int weight : weights) {
                if (sum + weight <= mid) {
                    sum += weight;
                } else {
                    days++;
                    sum = weight; //这里不用但心超载因为必定weight[x] <= mid
                }
            }
            if (days > D) {
                min = mid + 1;  //此时mid肯定不满足条件，所以可以直接向后移动一个
            }else {
                max = mid;
            }
        }
        return min;
    }

}
