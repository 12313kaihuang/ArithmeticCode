/**
 * 376. 摆动序列
 * <p>
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。
 * 相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 示例 1:
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * <p>
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * <p>
 * 示例 3:
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution376_1 {

    /**
     * 难点在于可以从原始序列中删除一些（也可以不删除）元素
     * <p>
     * 受到题解的启发，将数组各元素的值绘制成一个折线图，
     * 若图中有x段上升或下降的趋势，那么就需要由x+1个值组成，
     * 所以所需要求的最长子序列的长度也就为x+1
     * <p>
     * 每3个数会构成两个小段，记两数差为0时为0，差>0时为1，差<0时为-1，
     * 则共9种情况，其中0 1 | 0 -1 | 1 -1 | -1 1这四种组合时说明趋势变了，统计进去即可。
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int count = 1;
        int diff = 0; //表示当前的趋势是上升/下降还是平缓
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            if (diff == 0) {
                if (temp == 0) continue;//0 0
                //0 1 | 0 -1
                diff = temp;
                count++;
            } else {
                if (diff * temp < 0) {
                    //1 -1 | -1 1
                    diff = temp;
                    count++;
                }
            }
            //1 1 | -1 -1 | 1 0 | -1 0
            //这里不diff = temp的原因是趋势并没有变，所以不需要更新diff的值，例如1 2 2 3这个例子
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{0, 0}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{0, 0, 0}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{0, 0, 0, 1}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{0, 0, 0, 1, 0}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(new Solution376_1().wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
