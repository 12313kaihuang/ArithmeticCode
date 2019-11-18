package ArithmeticCode.SwordToOffer.code;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Hy on 2019/11/07 9:26
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
@SuppressWarnings({"InnerClassMayBeStatic", "unused"})
public class Test1 {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        String s = map.get(null);
        System.out.println(String.format("s = %s", s));
    }

    /**
     * 暴力破解
     * 遍历数组
     */
    public class Solution {
        public boolean Find(int target, int[][] array) {
            for (int[] row : array) {
                for (int value : row) {
                    if (target == value) return true;
                }
            }
            return false;
        }
    }

    /**
     * 从数组左下角看，向上是递减，向右是递增
     * 所以从左下角开始，大于该值向右滑，小于向上滑动，直到找到target或下标越界
     */
    public class Solution2 {
        public boolean Find(int target, int[][] array) {
            int i = array.length - 1, j = 0;
            //注意结束条件
            while (i >= 0 && j < array[0].length) {
                if (target == array[i][j]) return true;
                if (target > array[i][j]) {
                    j++;
                } else {
                    i--;
                }
            }
            return false;
        }
    }
}
