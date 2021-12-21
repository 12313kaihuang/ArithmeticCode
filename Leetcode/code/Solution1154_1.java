package Leetcode.code;

import java.util.Arrays;

/**
 * 1154. 一年中的第几天
 * <p>
 * 给你一个字符串date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。
 * 请你计算并返回该日期是当年的第几天。
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，
 * 依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * 示例 1：
 * 输入：date = "2019-01-09"
 * 输出：9
 * <p>
 * 示例 2：
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * 示例 3：
 * 输入：date = "2003-03-01"
 * 输出：60
 * <p>
 * 示例 4：
 * 输入：date = "2004-03-01"
 * 输出：61
 * <p>
 * 提示：
 * date.length == 10
 * date[4] == date[7] == '-'，其他的date[i]都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1154_1 {

    static int[] DAYS = new int[]{
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    //前i-1个月天数总和
    static int[] MONTH_DAYS = new int[13];

    static {
        for (int i = 2; i < 13; i++) {
            MONTH_DAYS[i] = MONTH_DAYS[i - 1] + DAYS[i - 1];
        }
    }

    public int dayOfYear(String date) {
        Integer[] dateArr = Arrays.stream(date.split("-")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 0; i < dateArr[1]; i++) {
            dateArr[2] += DAYS[i];
//            System.out.println("add " + DAYS[i]);
        }
        if (isLeapYear(dateArr[0]) && dateArr[1] > 2) dateArr[2]++;
        return dateArr[2];
    }

    public int dayOfYear2(String date) {
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        day += MONTH_DAYS[month];
        if (month > 2) {
            int year = Integer.parseInt(date.substring(0, 4));
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) day++;
        }
        return day;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1154_1().dayOfYear2("2012-01-02"));
    }
}
