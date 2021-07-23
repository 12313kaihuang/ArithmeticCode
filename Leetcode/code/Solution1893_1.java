package Leetcode.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * <p>
 * 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]
 * 表示一个从starti到endi的闭区间。如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，
 * 那么请你返回true，否则返回false。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，
 * 那么我们称整数x被覆盖了。
 * <p>
 * <p>
 * 示例 1：
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * <p>
 * 示例 2：
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 * <p>
 * <p>
 * 提示：
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1893_1 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] nums = new int[51];
        for (int[] arr : ranges) {
            for (int i = arr[0]; i <= arr[1]; i++) nums[i]++;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = left; i <= right; i++) {
            if (nums[i] == 0) return false;
        }
        return true;
    }

    //这样反而耗时还更多了
    public boolean isCovered2(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>();
        for (int i = left; i <= right; i++) set.add(i);
        for (int[] arr : ranges) {
            for (int i = arr[0]; i <= arr[1]; i++) {
                if (set.contains(i)) {
                    set.remove(i);
                    if (set.isEmpty()) return true;
                }
            }
        }
        return false;
    }

    //取交集的过程
    public boolean isCovered3(int[][] ranges, int left, int right) {
        return check(ranges, left, right, 0);
    }

    private boolean check(int[][] ranges, int left, int right, int index) {
        if (index >= ranges.length) return false;
//        System.out.println(String.format("%d %d ", left, right) + Arrays.toString(ranges[index]));
        int[] range = ranges[index++];
        //无交集
        if (range[0] > right || range[1] < left) {
            return check(ranges, left, right, index);
        }

        //有交集
        if (range[0] <= left && range[1] >= right) {
            return true;
        } else if (range[0] <= left) {
            return check(ranges, range[1] + 1, right, index);
        } else if (range[1] >= right) {
            return check(ranges, left, range[0] - 1, index);
        } else {
            return check(ranges, left, range[0] - 1, index)
                    && check(ranges, range[1] + 1, right, index);
        }
    }

    /**
     * 差分数组，计算前缀和
     * <p>
     * 作者：LaoGanMaIsEverything
     * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/yi-ti-san-jie-bao-li-you-hua-chai-fen-by-w7xv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isCovered4(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        int cur = 0;
        for (int i = 1; i <= right; i++) { //一定记得需要从头开始加
            cur += diff[i]; //此时cur表示i被覆盖的次数
            if (i >= left && cur <= 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1893_1().isCovered3(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
        System.out.println(new Solution1893_1().isCovered3(new int[][]{{2, 2}, {3, 3}, {1, 1}}, 1, 3));
    }
}
