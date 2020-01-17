package ArithmeticCode.SwordToOffer.code;

import java.util.ArrayList;

/**
 * Created by Hy on 2020/01/17 10:57
 * <p>
 * 和为S的两个数.md
 */
public class Test42 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0, hight = array.length - 1;
        while (hight > low) {
            int curSum = array[low] + array[hight];
            if (curSum == sum) {
                //从两边开始  相差最远的两个数乘积最小
                result.add(array[low]);
                result.add(array[hight]);
                return result;
            } else if (curSum < sum) {
                low++;
            } else {
                hight--;
            }
        }
        return result;
    }
}
