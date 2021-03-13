package Leetcode.code;

public class Solution705_2 {


    /**
     * -
     * 将暴力解法中的数组的每一个bool值替换成一个bit
     * java中一个int类型占4byte，32bit，
     * 32 * 4000 = 128-0000 > 10 ^ 6
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     **/
    class MyHashSet {

        int[] bs = new int[40000];

        public void add(int key) {
            int bucketIdx = key / 32; //应存入那个一个int值中
            int bitIdx = key % 32; //应存入int值的哪一位中
            setVal(bucketIdx, bitIdx, true);
        }

        public void remove(int key) {
            int bucketIdx = key / 32;
            int bitIdx = key % 32;
            setVal(bucketIdx, bitIdx, false);
        }

        public boolean contains(int key) {
            int bucketIdx = key / 32;
            int bitIdx = key % 32;
            return getVal(bucketIdx, bitIdx);
        }

        void setVal(int bucket, int loc, boolean val) {
            int u;
            if (val) {
                u = (bs[bucket] | (1 << loc));
            } else {
                u = bs[bucket] & ~(1 << loc);
            }
            bs[bucket] = u;
        }

        boolean getVal(int bucket, int loc) {
            int u = (bs[bucket] >> loc) & 1;
            return u == 1;
        }
    }

}
