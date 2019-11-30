package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/30 10:13
 *
 * 调整数组顺序使奇数位于偶数前面
 */

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    Test13().reOrderArray2(array)

    for (num in array) {
        println(num)
    }
}

class Test13 {

    fun reOrderArray(array: IntArray) {
        var k = 0
        val evenArray = ArrayList<Int>()

        for (num in array) {
            if (num and 1 == 1) {
                array[k++] = num
            } else {
                evenArray.add(num)
            }
        }

        for (even in evenArray) {
            array[k++] = even
        }
    }

    fun reOrderArray2(array: IntArray) {
        for (i in array.indices) {
            for (j in 0 until array.size - i - 1) {
                //前偶后奇交换
                if ((array[j] and 1 == 0) && (array[j + 1] and 1 == 1)) {
                    array[j] += array[j + 1]
                    array[j + 1] = array[j] - array[j + 1]
                    array[j] = array[j] - array[j + 1]
                }
            }
        }
    }

}