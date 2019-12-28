package ArithmeticCode.SwordToOffer.code;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Hy on 2019/12/28 9:57
 * <p>
 * 数组中出现次数超过一半的数字.md
 */
public class Test28 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution2(array));
    }

    /**
     * 根据用例推断，应该仅有一个数字满足要求。
     * 思路：
     * 1.首先遍历整个数组，并同时用一个map存储值及该值出现次数
     * 2.遍历map，找到出现次数大于数组长度一半的数
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new Hashtable<>();
        for (int num : array) {
            int count = map.get(num) == null ? 0 : map.get(num);
            if (count == 0) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }

        int len = array.length;
        for (int num : map.keySet()) {
            if (map.get(num) > len / 2) {
                return num;
            }
        }

        return 0;
    }

    public static int MoreThanHalfNum_Solution2(int[] array) {

        int num = array[0], count = 1;
        //核心在这个循环里面
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }

        //这里还需要做一个校验 ，
        // 因为如果数组中存在所求的数则num必为这个数，但若不存在所求的数num还是会有值
        count = 0;
        for (int value : array) {
            if (value == num) {
                count++;
            }
        }
        if (count * 2 > array.length) return num;
        return 0;
    }
}
