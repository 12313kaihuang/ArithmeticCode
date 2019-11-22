package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/22 9:58
 */
public class Test10 {

    public static void main(String[] args) {
        System.out.println(new Solution().RectCover2(3));
        System.out.println(new Solution().RectCover2(4));
        System.out.println(new Solution().RectCover2(5));
    }

    public static class Solution {
        public int RectCover(int target) {
            if (target <= 2)return target;
            return RectCover(target -1) + RectCover(target -2);
        }

        public int RectCover2(int target) {
            if (target <= 2)return target;
            int a = 1, b = 2;
            while (target-- > 2) {
                b = a + b;
                a = b - a;
            }
            return b;
        }
    }
}
