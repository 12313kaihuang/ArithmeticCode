package ArithmeticCode.SwordToOffer.code;

import java.util.*;

/**
 * Created by Hy on 2020/01/06 21:18
 * <p>
 * 把数组排成最小的数.md
 */
public class Test32 {

    public static void main(String[] args) {
        //[3,5,1,4,2]
        System.out.println("3".compareTo("2"));  //1
        System.out.println("32".compareTo("2")); //1
        System.out.println("32".compareTo("3")); //1
        System.out.println("321".compareTo("32")); //1
        System.out.println("321".compareTo("3")); //2
        System.out.println("3".compareTo("32")); //-1
        System.out.println();

        new Test32().PrintMinNumber(new int[]{3, 32, 321});
        System.out.println();
        new Test32().PrintMinNumber2(new int[]{3, 5, 1, 4, 2});

    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     * @param numbers 正整数数组
     * @return 接出的所有数字中最小的一个
     */
    public String PrintMinNumber(int[] numbers) {
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        //从小到大排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        //list.forEach(s::append);
        for (int j : list) {
            s.append(j);
        }
        return s.toString();

    }

    public String PrintMinNumber2(int[] numbers) {
        StringBuilder s = new StringBuilder();

        //冒泡排序
        int temp;
        String s1, s2;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                s1 = numbers[j] + "" + numbers[j + 1];
                s2 = numbers[j + 1] + "" + numbers[j];
                if (s1.compareTo(s2) > 0) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int num : numbers) {
            s.append(num);
        }
        return s.toString();
    }
}
