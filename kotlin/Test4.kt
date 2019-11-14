package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/14 9:40
 *
 * 重建二叉树
 */
fun main() {
    val pre = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val ine = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)
    buildTree(pre, 0, 0, ine, 0, 0)
}

fun buildTree(pre: IntArray, ps: Int, pe: Int, `in`: IntArray, `is`: Int, ie: Int): TreeNode? {

    //结束条件
    if (ps > pe || `is` > ie) {
        return null
    }

    val node = TreeNode(1)
    for (index in `in`.indices) {
        if (`in`[index] == pre[ps]) {
            //!!表示不为空的情况下执行
            node.left = buildTree(pre, ps + 1, ps + index - `is`, `in`, `is`, index - 1)
            node.right = buildTree(pre, ps + index - `is` + 1, pe, `in`, index + 1, ie)
        }
    }
    return node
}


