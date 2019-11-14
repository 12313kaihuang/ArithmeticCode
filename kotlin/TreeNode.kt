package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/14 12:50
 */
class TreeNode(val value: Int) {

    //默认变量需要在定义的时候就初始化值的
    //lateinit表明变量需要在定义后才赋值

    var left: TreeNode? = null
    var right: TreeNode? = null

}