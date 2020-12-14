package Leetcode.code;

/**
 * 62.不同路径
 */
public class Solution62_2 {
    /**
     * 20 10 4 1
     * 10 6 3 1
     * 4  3 2 1
     * 1  1 1 1
     * <p>
     *  从下往上，从右向左一步一步推算
     */
    int uniquePaths2(int m, int n) {
        int[] col = new int[m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 || j == m - 1) {
                    col[j] = 1; //边上的都为1
                } else {
                    //f(i,j) = f(i+1,j) + f(i,j+1)
                    //而此时col[j]还没有更新，即为f(i+1,j)
                    col[j] = col[j] + col[j + 1];
                }
            }
        }
        return col[0];
    }
}
