package SwordToOffer.code;


import common.TreeNode;

/**
 * Created by Hy on 2019/12/23 9:38
 */
public class Test26 {

    private TreeNode currentHead;

    //最终排序结果其实就是二叉搜索树的中序遍历结果
    public TreeNode Convert(TreeNode pRootOfTree) {
        //预先设置一个假的head 便于统一化处理每个节点
        TreeNode head = new TreeNode(0);
        currentHead = head;
        if (pRootOfTree == null) {
            return null;
        }
        midAssess(pRootOfTree);

        //验证程序会进行从左到右和从右到左的遍历验证结果
        //所以这里需要将这里假的head移除掉否则从右到左遍历会多出一个节点
        TreeNode realHead = head.right;
        realHead.left = null;
        return realHead;
    }

    private void midAssess(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            midAssess(treeNode.left);
        }
        //赋值
        currentHead.right = treeNode;
        treeNode.left = currentHead;
        currentHead = currentHead.right;
        if (treeNode.right != null) {
            midAssess(treeNode.right);
        }
    }

    //中序遍历
    private static void print(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            print(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            print(node.right);
        }
    }

    private static void print2(TreeNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        //print(root);


        print2(new Test26().Convert(root));
    }


    private static void test2(){

    }
}
