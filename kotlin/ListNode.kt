package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/12 9:55
 *
 * 加上var会有
 */
class ListNode(private var value: Int) {
    var next: ListNode? = null

    fun getValue(): Int = value
}
