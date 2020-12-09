package Leetcode.code;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 * 输入：m = 3, n = 2
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 7, n = 3
 * 输出：28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test62_1 {

    public int uniquePaths(int m, int n) {
        return pointByPath(m, n, 1, 1);
    }

    //超时了
    int pointByPath(int m, int n, int x, int y) {
        if (x > m || y > n) return 0;
        if (x == m || y == n) return 1;  //用或而不是与的原因是因为只能向下或向右，所以只要移动到边上了就只能朝着一个方向移动了
        return pointByPath(m, n, x + 1, y) + pointByPath(m, n, x, y + 1); //这里仍存在很多重复计算
    }


    public static void main(String[] args) {
        Test62_1 solution = new Test62_1();
        Test62_2 solution2 = new Test62_2();
        System.out.println(solution.uniquePaths(7, 3));
        System.out.println(solution2.uniquePaths2(7, 3));
    }
}
