package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/18 9:39
 * <p>
 * 跳台阶
 */
public class Test8 {


    //递归
    public class Solution {
        public int JumpFloor(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public class Solution2 {
        public int JumpFloor(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            int a = 1, b = 2;
            while (target-- > 2) {
                b += a;
                a = b - a;
            }
            return b;
        }
    }


}
