package ArithmeticCode.SwordToOffer.code;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Hy on 2020/01/15 9:53
 * <p>
 * 数组中只出现一次的数字.md
 */
public class Test39 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        //利用LinkedHashSet，遍历array，如果没有元素则添加，有则说明出现第二次了，这时删除存储的数即可
        //最后剩下的两个数就是所求结果了
        Set<Integer> nums = new LinkedHashSet<>();
        for (int num : array) {
            if (nums.contains(num)) {
                nums.remove(num);
            } else {
                nums.add(num);
            }
        }

        Iterator<Integer> iterator = nums.iterator();
        if (iterator.hasNext()) {
            num1[0] = iterator.next();
        }
        if (iterator.hasNext()) {
            num2[0] = iterator.next();
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?f=discussion
     * 来源：牛客网
     * <p>
     * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     */
    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        int bitResult = 0;
        //计算两个只出现一次的数异或的结果。
        for (int num : array) {
            //a & a = 0， a & 0 = a
            bitResult ^= num;
        }

        //此时bitResult = num1 ^ num1,找到从右到左num1,num1第一个不同的bit位的位置
        int index = findFirst1(bitResult);
        //进行分组，将num1，num2分开
        for (int num : array) {
            if (isBit(num, index)) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    //找到两个数从右到左第一个不同的bit位的位置
    //即从右到左第一个 1 的位置
    private int findFirst1(int bitResult) {
        int index = 0;
        while ((bitResult & 1) == 0 && index < 32) {
            bitResult = bitResult >> 1;
            index++;
        }
        return index;
    }

    private boolean isBit(int num, int index) {
        return ((num >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Test39().FindNumsAppearOnce2(array, num1, num2);
    }
}
