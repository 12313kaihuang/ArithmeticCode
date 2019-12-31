package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/12/31 9:40
 * <p>
 * 连续子数组的最大和
 */
public class Test30 {

    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        int[] array2 = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("ss" + new Test30().FindGreatestSumOfSubArray2(array2));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curMax = 0;
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (curMax <= 0) {
                //如果当前和小于等于0，归零
                curMax = value;
            } else {
                //否则累加
                curMax += value;
            }
            //记录最大值
            max = Math.max(curMax, max);
        }
        return max;
    }

    /**
     * 动态规划
     * f(i) = max( f(i-1)+array[i] , array[i] )
     * max = max( f(1) ,f(2), f(3),...,f(i) )
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];//用于存储最大值
        int curMax = array[0]; //f(i)
        for (int i = 1; i < array.length; i++) {
            curMax = Math.max(curMax + array[i], array[i]);
            max = Math.max(max, curMax);
            System.out.printf("i = %d,curMax = %d,max = %d\n", i, curMax, max);
        }
        System.out.println(curMax);
        return max;
    }
}
