package ArithmeticCode.SwordToOffer.code;

import java.time.OffsetDateTime;
import java.util.ArrayList;

/**
 * Created by Hy on 2019/12/12 9:44
 * <p>
 * 顺时针打印矩阵.md
 */
public class Test19 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}
        };

        //特殊情况  左 从下到上时需加right >= left判断
        int[][] matrix2 = new int[][]{
                new int[]{1},
                new int[]{2},
                new int[]{3},
                new int[]{4},
                new int[]{5}
        };

        //特殊情况  下  从右到左  bottom >= top为了解决只有一行的特殊情况
        int[][] matrix3 = new int[][]{
                new int[]{1, 2, 3, 4, 5}
        };

        ArrayList<Integer> list = printMatrix(matrix3);
        for (Integer integer : list) {
            System.out.printf("%s ", integer);
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }

        int row = matrix.length;  //行数
        int column = matrix[0].length; //列数
        int left = 0, right = column - 1, top = 0, bottom = row - 1;
        int count = 0, total = row * column;
        while (count < total) {
            //上  从左到右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                count++;
            }
            top++;

            //右 从上到下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                count++;
            }
            right--;

            //下  从右到左  bottom >= top为了解决只有一行的特殊情况
            for (int i = right; bottom >= top && i >= left; i--) {
                result.add(matrix[bottom][i]);
                count++;
            }
            bottom--;

            //左 从下到上  right >= left为了解决只有一列的特殊情况
            for (int i = bottom; right >= left && i >= top; i--) {
                result.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return result;
    }

}
