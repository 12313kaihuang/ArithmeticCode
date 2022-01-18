package Leetcode.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 * <p>
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * <p>
 * 提示：
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution539_1 {

    /**
     * 排序
     */
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int min = getMins(timePoints.get(0)) + 1440 - getMins(timePoints.get(timePoints.size() - 1));
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMins(timePoints.get(i)) - getMins(timePoints.get(i - 1));
            System.out.println(minutes);
            min = Math.min(min, minutes);
        }
        return min;
    }

    /**
     * 鸽笼原理
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-time-difference/solution/zui-xiao-shi-jian-chai-by-leetcode-solut-xolj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findMinDifference2(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0; //?默认时间不重复？
        Collections.sort(timePoints);
        int preMins = getMinutes(timePoints.get(0));
        int ans = preMins + 1440 - getMinutes(timePoints.get(n - 1));
        for (int i = 1; i < n; i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMins);
            preMins = minutes; //避免重复计算
        }
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

    private int getMins(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {{
            add("00:00");
            add("04:00");
            add("22:00");
        }};
        System.out.println(new Solution539_1().findMinDifference2(list));
    }
}
