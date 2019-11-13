package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/13 11:53
 *斐波那契数列
 */
fun main() {

    println(Solution().Fibonacci(6)) //8
    println(Solution().Fibonaci2(6)) //8
}

class Solution {

    //递归
    fun Fibonacci(n: Int): Int {
        return when (n) {
            0 -> 0
            1, 2 -> 1
            else -> Fibonacci(n - 1) + Fibonacci(n - 2)
        }
    }

    //循环
    fun Fibonaci2( n: Int): Int {
        when (n) {
            0 -> return 0
            1, 2 -> return 1
        }

        var a = 1
        var b = 1
        var m = n
        while (m-- > 2) {
            b += a
            a = b-a
        }
        return b
    }
}