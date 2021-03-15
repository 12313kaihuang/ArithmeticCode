package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution54_1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        int direction = 0, x = 0, y = 0;  //0 1 2 3 分别对应向右、向下、向左、向右
        while (l <= r && t <= b) {
//            System.out.println(String.format("add arr[%d][%d] %d", x, y, matrix[y][x]));
            list.add(matrix[y][x]);
            if (direction == 0) {
                if (x < r) x++;
                else {
                    y = ++t; //t++;y++;
                    direction = 1;
                }
            } else if (direction == 1) {
                if (y < b) y++;
                else {
                    x = --r; //r--;x--;
                    direction = 2;
                }
            } else if (direction == 2) {
                if (x > l) x--;
                else {
                    y = --b; //b--;y--;
                    direction = 3;
                }
            } else {
                if (y > t) y--;
                else {
                    x = ++l; //l++;x++;
                    direction = 0;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution54_1().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution54_1().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

}
