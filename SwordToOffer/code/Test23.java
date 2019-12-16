package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/12/16 9:33
 * <p>
 * 二叉搜索树的后序遍历序列.md
 */
public class Test23 {
    public static void main(String[] args) {

    }

    public static class Solution {
        @SuppressWarnings("unused")
        public boolean VerifySquenceOfBST(int[] sequence) {

            return isOk(sequence, 0, sequence.length - 1);
        }

        /**
         * @param sequence 后续遍历结果
         * @param start    当前子树后续遍历结果的起始位置
         * @param end      当前子树后续遍历结果的结束位置
         * @return 是否满足二叉搜索树的条件
         */
        private boolean isOk(int[] sequence, int start, int end) {
            if (sequence == null || sequence.length == 0) {
                return false;
            }
            if (start >= end) {
                //左子树只有一个节点或左子树为空
                return true;
            }
            //从左到右找到第一个大于sequence[end]（即当前根节点）的值
            //即找到右子树的第一个节点的位置
            int i = start;
            while (sequence[i] < sequence[end]) i++;

            //判断右子树的节点是否都大于根节点
            for (int j = i; j <= end; j++) {
                if (sequence[j] < sequence[end]) {
                    return false;
                }
            }

            return isOk(sequence, start, i - 1) && isOk(sequence, i, end - 1);
        }
    }
}


