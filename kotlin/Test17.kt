package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/12/10 9:42
 */

fun main() {

}

class Test17 {
    fun HasSubtree(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root2 == null || root1 == null) return false
        return isSubTree(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2)

    }

    fun isSubTree(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root2 == null) return true
        if (root1 == null) return false
        if (root1.value == root2.value) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right)
        }
        return false
    }
}