package ArithmeticCode.SwordToOffer.code;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hy on 2020/01/08 9:57
 * <p>
 * 丑叔
 */
public class Test33 {

    public static void main(String[] args) {
        Test33 test = new Test33();
        System.out.println(test.GetUglyNumber_Solution(1));
        System.out.println(test.GetUglyNumber_Solution(2));
        System.out.println(test.GetUglyNumber_Solution(3));
        System.out.println(test.GetUglyNumber_Solution(4));
        System.out.println(test.GetUglyNumber_Solution(5));
        System.out.println(test.GetUglyNumber_Solution(6));
        System.out.println(test.GetUglyNumber_Solution(7));
        System.out.println(test.GetUglyNumber_Solution(8));
        System.out.println(test.GetUglyNumber_Solution(9));
        System.out.println(test.GetUglyNumber_Solution(10));
        System.out.println(test.GetUglyNumber_Solution(11));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int p2 = 0, p3 = 0, p5 = 0;
        int n2, n3, n5;
        int newNum = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < index) {
            n2 = list.get(p2) * 2;
            n3 = list.get(p3) * 3;
            n5 = list.get(p5) * 5;
            newNum = Math.min(n2, Math.min(n3, n5));  //最小值
            if (n2 == newNum) p2++;
            if (n3 == newNum) p3++;
            if (n5 == newNum) p5++;
            list.add(newNum);
        }
        return newNum;
    }

}
