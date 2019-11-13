package ArithmeticCode.kotlin

import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by Hy on 2019/11/07 10:15
 */

//程序入口
fun main() {
    Test.Companion.Solution().Find(
        5, arrayOf(
            intArrayOf(1, 2, 8, 9),
            intArrayOf(2, 4, 9, 12),
            intArrayOf(4, 7, 10, 13),
            intArrayOf(6, 8, 11, 15)
        )
    )

    print(Test.Companion.Solution().replaceSpace(StringBuffer("we are family")))

}

class Test {

    companion object {

        //二维数组中的查找
        class Solution {

            fun Find(target: Int, array: Array<IntArray>): Boolean {
                for (arr in array) {
                    for (value in arr) {
                        if (target == value) return true
                    }
                }
                return false;
            }

            /**
             * 从数组左下角看，向上是递减，向右是递增
             * 所以从左下角开始，大于该值向右滑，小于向上滑动，直到找到target或下标越界
             */
            fun Find2(target: Int, array: Array<IntArray>): Boolean {
                var i = array.size - 1;
                var j = 0;
                while (i >= 0 && j < array[0].size) {
                    when {
                        target == array[i][j] -> return true
                        target > array[i][j] -> j++
                        else -> i--
                    }
                }
                return false
            }

            fun replaceSpace(str: StringBuffer): String {
                var spaceNum = 0;
                for (c in str) {
                    if (c == ' ') spaceNum++
                }
                val newLength = str.length + spaceNum * 2
                val oldIndex = str.length - 1
                var newIndex: Int = newLength - 1;
                str.setLength(newLength)

                for (i in oldIndex downTo 0) {
                    if (i > newLength) break
                    when (str[i]) {
                        ' ' -> {
                            str.setCharAt(newIndex--, '0')
                            str.setCharAt(newIndex--, '2')
                            str.setCharAt(newIndex--, '%')
                        }
                        else -> str.setCharAt(newIndex--, str[i])
                    }
                }
                return str.toString()
            }
        }

        fun printListFromTailToHead(listNode: ListNode?): ArrayList<Int> {
            var node = listNode;
            val stack = Stack<Int>()
            while (node != null) {
                //stack.push(node.getValue())
                node = node.next
            }

            val list = ArrayList<Int>()
            while (!stack.isEmpty()) {
                list.add(stack.pop())
            }
            return list
        }
    }
}