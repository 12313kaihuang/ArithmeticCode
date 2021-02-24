package Leetcode.code;

import java.util.Arrays;

/**
 * 832. 翻转图像
 * <p>
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 * <p>
 * 示例 1：
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * 示例 2：
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution832_2 {

    /**
     * l r  -> l r
     * 0 0     1 1
     * 0 1     0 1
     * 1 1     0 0
     * 1 0     1 0
     * <p>
     * 所以当arr[l] != arr[r]时，是不需要做操作的
     * 使用异或来简化赋值操作
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int size = A[0].length;
        for (int[] arr : A) {
            int l = 0, r = size - 1;
            while (l < r) {
                if (arr[l] == arr[r]) {
                    arr[l] ^= 1;
                    arr[r] ^= 1;
                }
                l++;
                r--;
            }
            if (l == r) {
                arr[l] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        //[[1,1,0],[1,0,1],[0,0,0]]
        int[] arr1 = new int[]{1, 1, 0};
        int[] arr2 = new int[]{1, 0, 1};
        int[] arr3 = new int[]{0, 0, 0};
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 1);
        System.out.println(Arrays.deepToString(new Solution832_2().flipAndInvertImage(new int[][]{arr1, arr2, arr3})));
    }
}
