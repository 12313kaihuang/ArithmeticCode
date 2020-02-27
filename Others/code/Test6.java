package ArithmeticCode.Others.code;

import java.util.ArrayList;

/**
 * @author Hy
 * @date 2020/02/27 10:42
 * @description 无限循环打印字符串.md
 **/
public class Test6 {
    public static void main(String[] args) {
        //给定一个字符串，为每一个字符创建一个独立的线程，该线程无限循环打印该字符。这些线程合作，确保输出的字符串是输入字符串的无限重复。
        String s = new String("123");
        print(s.toCharArray());
    }

    public static int index = 0; //用于记录当前需要打印的字符下标
    public static int now = 0;  //当前已打印个数
    public static int max = 30;  //共需要打印字符数

    public static void print(char[] chars) {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            final int fi = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            synchronized (chars) {
                                while (index != fi) {
                                    chars.wait();
                                }
                                System.out.println(chars[fi]);
                                now++;
                                if (now > max) {
                                    break;
                                }
                                index = (index + 1) % chars.length;
                                chars.notifyAll();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
