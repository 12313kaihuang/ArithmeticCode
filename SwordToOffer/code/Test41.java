package ArithmeticCode.SwordToOffer.code;

import java.util.ArrayList;

/**
 * Created by Hy on 2020/01/17 10:28
 * <p>
 * 和为S的连续正数序列.md
 */
public class Test41 {

    //和为S的连续正数序列
    //由于是从连续正数序列中去找到满足条件的数  可以使用滑动窗口策略
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        //要求连续正数序列 则单个的如1 2 这样的不算，所以sum >= 3的。
        while (high > low) {
            //等差数列求和
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {
                //如果等于加入结果中
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                //low向右滑动
                low++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Test41().FindContinuousSequence(3));
    }
}
