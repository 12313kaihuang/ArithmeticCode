package Leetcode.code;


import java.util.Arrays;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：[5,5,5,10,20]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：[5,5,10]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：[5,5,10,10,20]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test860_1 {

    public boolean lemonadeChange(int[] bills) {
        //changes[0]存储当前5元张数，changes[1]为10元张数
        int[] changes = new int[2];
        Arrays.fill(changes, 0);
        return change(bills, 0, changes);
    }

    //给20这里，有两种找零方式：3张5元或者1张5元1张10元
    //所以考虑使用递归，但是这样会很耗时，且额外复制一个数组也很占内存
    private boolean change(int[] bills, int index, int[] changes) {
        //System.out.printf("%d - %s\n", index, Arrays.toString(changes));
        if (changes[0] < 0 || changes[1] < 0) return false;
        if (index >= bills.length) return true;
        //优先尝试1张5 一张10
        switch (bills[index]) {
            case 5 -> {
                changes[0]++;
                return change(bills, index + 1, changes);
            }
            case 10 -> {
                changes[1]++;
                changes[0]--;
                return change(bills, index + 1, changes);
            }
            case 20 -> {
                int[] newChanges = new int[]{changes[0], changes[1]};
                changes[0]--;
                changes[1]--;
                if (change(bills, index + 1, changes)) {
                    return true;
                } else {
                    //尝试3张5
                    newChanges[0] -= 3;
                    return change(bills, index + 1, newChanges);
                }
            }
            default -> throw new RuntimeException("unknown bill");
        }

    }

    /**
     * 一开始把问题想复杂了，纠结会不会出现一种情况：给我20元我找一张10元一张5元后，后面没有零钱找了，但是要是找3张5元就能找开。或者出现反过来的情况。
     * 看了题解说如果有10元优先使用10元+5元的组合，然后又仔细思考了一下发现，只有给我20元的时候有可能会用到10元钱。
     * 所以，当我收到20元时，如果我找10+5之后后面没零钱找了，那么我找3张5元后面肯定也会没有零钱找；
     * 但是如果反过来就不一定了，如果我找3张5元找不开，换成10+5不一定就找不开。
     * 所以如果优先使用10+5找零，就不会出现“回溯”的问题。
     */
    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true/*five >= 0 && ten >= 0*/;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
        System.out.println(new Test860_1().lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5}));
        System.out.println(new Test860_2().lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5}));
    }
}
