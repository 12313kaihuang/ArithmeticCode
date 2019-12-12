package ArithmeticCode.kotlin

import java.util.*

/**
 * Created by Hy on 2019/12/12 9:32
 */

fun main() {

}

class Test18 {

    fun Mirror(treeNode: TreeNode?) {
        revert(treeNode)
    }

    private fun revert(treeNode: TreeNode?) {
        if (treeNode == null) {
            return
        }

        val node = treeNode.left
        treeNode.left = treeNode.right
        treeNode.right = node

        revert(treeNode.left)
        revert(treeNode.right)

    }

    //非递归
    fun Mirror2(treeNode: TreeNode?) {

        val stack = Stack<TreeNode>()
        stack.push(treeNode)

        while (!stack.isEmpty()) {
            val node = stack.pop()
            if (node != null) {
                val temp = node.left
                node.left = node.right
                node.right = temp
            }

            stack.push(node.right)
            stack.push(node.left)

        }
    }
}