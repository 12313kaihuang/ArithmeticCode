package ArithmeticCode.kotlin


/**
 * Created by Hy on 2019/12/02 9:56
 */
fun main() {

}

class Test14 {

    fun FindKthToTail(head: ListNode?, k: Int): ListNode? {
        var i = 0
        var kNode = head
        //head不为空才执行
        head?.let {
            var p = head
            while (p != null) {
                if (i >= k) {
                    kNode = kNode?.next
                }
                p = p.next
                i++
            }
        }
        return when (i) {
            in 0 until k -> null
            else -> kNode
        }
    }
}