package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/12/03 9:56
 */
fun main() {

}

class Test15 {

    fun ReverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var pre: ListNode? = null
        var now = head
        var next: ListNode?

        while (now != null) {
            next = now.next
            now.next = pre
            pre = now
            now = next
        }
        return pre
    }
}