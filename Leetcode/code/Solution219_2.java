package Leetcode.code;

import java.util.Arrays;
import java.util.Comparator;

public class Solution219_2 {

    /**
     * 另辟蹊径，记录下标并排序
     * <p>
     * 作者：Echo__wwW
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/javajie-fa-ling-pi-xi-jing-er-wei-shu-zu-s94f/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
//        System.out.println(Arrays.deepToString(arr));
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
//        System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < nums.length - 1; i++) {
            if (arr[i][0] == arr[i + 1][0] && arr[i + 1][1] - arr[i][1] <= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution219_2().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
