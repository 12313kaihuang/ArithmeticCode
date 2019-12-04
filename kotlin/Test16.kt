package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/12/04 10:49
 */
fun main() {

}

@Suppress("unused")
class Test16 {

    fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        } else if (list2 == null) {
            return list1
        } else {
            if (list1.getValue() > list2.getValue()) {
                list2.next = merge(list1, list2.next)
                return list2
            } else {
                list1.next = merge(list1.next, list2)
                return list1
            }
        }
    }
}