package Leetcode.others;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * <p>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class InterviewSolution17_14_1 {

    /**
     * 排序
     */
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    //因为不要求顺序 所以还可以这么做
    public int[] smallestK2(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) return ans;
        int maxPos = 0;
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
            if (ans[i] > ans[maxPos]) maxPos = i;
        }

        for (int i = k; i < arr.length; i++) {
            //每次替换最大的
            if (arr[i] < ans[maxPos]) {
                ans[maxPos] = arr[i];
                //这里每次查找太耗时了
                for (int j = 0; j < k; j++) {
                    if (ans[j] > ans[maxPos]) maxPos = j;
                }
            }
        }
        return ans;
    }

    //根据2的思路可以改成使用堆来实现
    public int[] smallestK3(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) return ans;
        //从大到小排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
