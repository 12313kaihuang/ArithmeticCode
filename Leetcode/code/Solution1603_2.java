package Leetcode.code;

public class Solution1603_2 {

    public static void main(String[] args) {
        //1 0000000001 0000000000
        ParkingSystem2 system = new ParkingSystem2(2, 1, 0);
        System.out.println(system.addCar(1));
        System.out.println(system.addCar(2));
        System.out.println(system.addCar(3));
        System.out.println(system.addCar(1));
    }

}

class ParkingSystem2 {

    /**
     * 1000000000010000000000
     * 100000000010000000000
     * 因为每个停车位最大1000个，而1000转换为二进制为1111101000
     * Int类型占32位，三个停车位最多占用30位，所以为了节省空间可以
     * 使用一个Int来做位运算达到目的。
     */
    int parkingSpot = 0;

    public ParkingSystem2(int big, int medium, int small) {
        //从左向右，第3位开始算，每10位看做一个二进制数，存储对应型号的车位数
        // 第3-12位存big 13-22存medium 23-32存small
        parkingSpot |= big;
        parkingSpot = parkingSpot << 10;
        parkingSpot |= medium;
        parkingSpot = parkingSpot << 10;
        parkingSpot |= small;
        //System.out.println(Integer.toBinaryString(parkingSpot));
    }

    public boolean addCar(int carType) {
        //1023 --> 11 1111 1111
        int temp = (parkingSpot >> (30 - carType * 10)) & 1023;
        //System.out.println("temp = " + temp);
        if (temp <= 0) {
            return false;
        }
        //赋值为对应阶层的“1”
        //例如carType为1 则对应的应该是 1 0000000000 0000000000
        //carType为3 则对应 1
        temp = 1 << (30 - carType * 10);
        //System.out.println("before:\nparkingSpot =" + format(parkingSpot) + "\ntemp=" + format(temp));
        parkingSpot -= temp; //减去“1”个对应的车位
        //System.out.println("parkingSpot =" + format(parkingSpot));
        return true;
    }

    public boolean addCar2(int carType) {
        //1023 --> 11 1111 1111
        if (((parkingSpot >> (30 - carType * 10)) & 1023) <= 0) {
            return false;
        }
        //赋值为对应阶层的“1”
        //例如carType为1 则对应的应该是 1 0000000000 0000000000
        //carType为3 则对应 1
        parkingSpot -= 1 << (30 - carType * 10); //减去“1”个对应的车位
        return true;
    }


    private String format(int num) {
        String s = Integer.toBinaryString(num);
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        int first = len % 10;
        builder.append(s, 0, first).append(" ");
        for (int i = first; i < len - 1; i += 10) {
            builder.append(s, i, Math.min((i + 10), len)).append(" ");
        }
        //System.out.println("format " + s + "; " + builder.toString());
        return builder.toString();
    }
}
