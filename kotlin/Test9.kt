package ArithmeticCode.kotlin

import kotlin.math.roundToInt

/**
 * Created by Hy on 2019/11/19 10:09
 */
fun main() {

    println(jumpFloor33(4))

}

fun jumpFloor33(target: Int): Int {
    return when (target) {
        in 0..1 -> 1
        else -> {
            val r = 1
            r.shl(target - 1)
        }
    }
}

fun pow(base: Int, x: Int): Int {
    if (x == 0) return 1
    val result = 1
    return result.shl(x)
}