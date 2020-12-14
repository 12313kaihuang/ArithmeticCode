package Leetcode.code;


public class Solution860_2 {


    /**
     * 一开始把问题想复杂了，纠结会不会出现一种情况：给我20元我找一张10元一张5元后，后面没有零钱找了，但是要是找3张5元就能找开。或者出现反过来的情况。
     * 看了题解说如果有10元优先使用10元+5元的组合，然后又仔细思考了一下发现，只有给我20元的时候有可能会用到10元钱。
     * 所以，当我收到20元时，如果我找10+5之后后面没零钱找了，那么我找3张5元后面肯定也会没有零钱找；
     * 但是如果反过来就不一定了，如果我找3张5元找不开，换成10+5不一定就找不开。
     * 所以如果优先使用10+5找零，就不会出现“回溯”的问题。
     */
    public boolean lemonadeChange(int[] bills) {
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

}
