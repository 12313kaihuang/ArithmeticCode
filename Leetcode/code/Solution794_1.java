package Leetcode.code;

/**
 * 794. 有效的井字游戏
 * <p>
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，
 * 棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * 示例 1：
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 * <p>
 * 示例 2：
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 * <p>
 * 示例 3：
 * 输入：board = ["XXX","   ","OOO"]
 * 输出：false
 * <p>
 * Example 4:
 * 输入：board = ["XOX","O O","XOX"]
 * 输出：true
 * <p>
 * 提示：
 * board.length == 3
 * board[i].length == 3
 * board[i][j] 为 'X'、'O' 或 ' '
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution794_1 {

    /**
     * 应该是默认1先下的
     * <p>
     * 朴素解法
     */
    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') countX++;
                else if (c == 'O') countO++;
            }
        }
        if (countO > countX || (countX - countO) > 1) return false;
        if (countX < 3) return true;
        int finish = checkFinish(board);
        System.out.println("checkFinish :" + (char) finish);
        if (finish == 'X') {
            return countX > countO;
        } else if (finish == 'O') {
            return countX == countO;
        }
        return true;
    }

    private int checkFinish(String[] board) {
        char c;
        //行
        for (int i = 0; i < 3; i++) {
            c = board[i].charAt(1);
            if (c != ' ' && board[i].charAt(0) == c && c == board[i].charAt(2))
                return c;
        }
        //列
        for (int i = 0; i < 3; i++) {
            c = board[1].charAt(i);
            if (c != ' ' && c == board[0].charAt(i) && c == board[2].charAt(i))
                return c;
        }
        c = board[1].charAt(1);
        if (c != ' ' && c == board[0].charAt(0) && c == board[2].charAt(2)) return c;
        if (c != ' ' && c == board[0].charAt(2) && c == board[2].charAt(0)) return c;
        return -1;
    }


    /**
     * 官方题解 思路差不多,速度快很多？？
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state/solution/you-xiao-de-jing-zi-you-xi-by-leetcode-s-c1j3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean validTicTacToe2(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                xCount = (c == 'X') ? (xCount + 1) : xCount;
                oCount = (c == 'O') ? (oCount + 1) : oCount;
            }
        }
        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
        }
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }


}
