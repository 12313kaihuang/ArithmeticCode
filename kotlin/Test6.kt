package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/15 9:40
 *
 * 旋转数组的最小数字
 */
fun main() {

    Test6().minNumberInRotateArray(intArrayOf(1, 2, 3))

}

class Test6 {
    fun minNumberInRotateArray(array: IntArray): Int {
        if (array.size == 0) return 0
        var result = array[0]
        for (i in array.indices) {
            if (array[i] > array[i + 1]) result = array[i + 1]
        }
        return result
    }

    fun minNumberInRotateArray2(array: IntArray): Int {
        var low = 0;
        var high = array.size - 1
        var mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2
            when {
                array[mid] > array[high] -> low = mid + 1
                array[mid] == array[high] -> high--
                array[mid] < array[high] -> high = mid
            }
        }
        return array[low]
    }


}

