package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2020/01/16 11:05
 * <p>
 * 求1+2+...+n.md
 */
public class Test40 {

    //递归 + 短路特性
    public int Sum_Solution(int n) {
        int res = n;
        boolean b = (res != 0) && (res += Sum_Solution(n - 1)) != 0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test40().Sum_Solution(4));
        System.out.println(new Test40().Sum_Solution(5));
        System.out.println(new Test40().Sum_Solution(50));
    }
}
