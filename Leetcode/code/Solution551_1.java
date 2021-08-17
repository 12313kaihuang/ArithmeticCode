package Leetcode.code;

/**
 * 551. 学生出勤记录 I
 * <p>
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。
 * 记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * <p>
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * <p>
 * 示例 2：
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution551_1 {

    public boolean checkRecord(String s) {
        int len = s.length();
        int timeA = 0, timeL = 0, lastL = -1;
        for (int i = 0; i < len && timeA < 2 && timeL < 3; i++) {
            char c = s.charAt(i);
            if (c == 'A') timeA++;
            else if (c == 'L') {
                timeL = lastL + 1 == i ? timeL + 1 : 1;
                lastL = i;
            }
        }
        return timeA < 2 && timeL < 3;
    }

    //lastL可以省略掉
    public boolean checkRecord2(String s) {
        int len = s.length();
        int timeA = 0, timeL = 0;
        for (int i = 0; i < len && timeA < 2; i++) {
            char c = s.charAt(i);
            if (c == 'A') timeA++;
            if (c == 'L') {
                timeL++;
                if (timeL >= 3) return false;
            } else timeL = 0;
        }
        return timeA < 2;
    }

    //???
    public boolean checkRecord3(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
