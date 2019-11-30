package ArithmeticCode.SwordToOffer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hy on 2019/11/29 9:47
 * <p>
 * 调整数组顺序使奇数位于偶数前面
 */
public class Test13 {

    public static class Solution {
        public void reOrderArray(int[] array) {
            int k = 0; //已放好的奇数个数 & 下一个奇数需要放的位置
            //暂存偶数
            List<Integer> evenList = new ArrayList<>();
            //遍历
            for (int i = 0; i < array.length; i++) {
                if ((array[i] & 1) == 1) {
                    //奇数
                    array[k++] = array[i];
                } else {
                    //偶数
                    evenList.add(array[i]);
                }
            }

            //将偶数放回去
            for (int i : evenList) {
                array[k++] = i;
            }
        }

        public void reOrderArray2(int[] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = array.length - 1; j > i; j--) {
                    if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                        //前偶后奇交换
                        array[j] += array[j - 1];
                        array[j - 1] = array[j] - array[j - 1];
                        array[j] = array[j] - array[j - 1];
                    }
                }
            }
        }
    }


}
