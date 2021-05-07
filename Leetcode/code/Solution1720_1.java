package Leetcode.code;

/**
 * 1720. 解码异或后的数组
 * <p>
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * 示例 1：
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * <p>
 * 示例 2：
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 * <p>
 * 提示：
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1720_1 {

    /**
     * 官方题解：
     * 可以利用异或运算的性质实现。
     * 异或运算具有如下性质：
     * 1. 异或运算满足交换律和结合律；即a ^ b = b ^ a，则有(a ^ b) ^ c= a ^ (b ^ c)；
     * 2. 任意整数和自身做异或运算的结果都等于 0，即 x ^ x = 0；
     * 3. 任意整数和 0 做异或运算的结果都等于其自身，即 x ^ 0 = 0;
     * <p>
     * 推算过程：
     * c = a ^ b -> c ^ a = (a ^ b) ^ a -> c ^ a = [a ^ a ^ b =  0 ^ b = b]
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/decode-xored-array/solution/jie-ma-yi-huo-hou-de-shu-zu-by-leetcode-yp0mg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            //encoded[x] = arr[x] ^ arr[x + 1]
            //交换律转换：arr[x + 1] = encoded[x] ^ arr[x]
            //取i=x+1：arr[i] = encoded[i - 1] ^ arr[i - 1]
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
