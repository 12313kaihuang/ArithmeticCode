package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/15 9:40
 * <p>
 * 旋转数组的最小数字
 */
public class Test6 {

    //顺序查找
    public class Solution {
        public int minNumberInRotateArray(int[] array) {
            if (array.length == 0) return 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return array[i + 1];
                }
            }
            //如果旋转了数组这种情况时不太可能会出现的
            return 0;
        }
    }

    //二分法查找
    public class Solution2 {
        public int minNumberInRotateArray(int[] array) {
            int low = 0, high = array.length - 1;
            int mid;
            while (high > low) {
                mid = low + (high - low) / 2;
                if (array[mid] > array[high]) {
                    low = mid + 1;
                } else if (array[mid] == array[high]) {
                    high--;
                } else if (array[mid] < array[high]) {
                    high = mid;
                }
            }
            return array[low];
        }
    }
}
