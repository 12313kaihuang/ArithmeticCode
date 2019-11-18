package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/18 10:24
 *
 * 跳台阶
 * 1 2 3 5 8 13
 */
fun main() {
    println(jumpFloor2(6))  //13
}

fun jumpFloor(target: Int): Int {
    return when (target) {
        1 -> 1
        2 -> 2
        else -> jumpFloor(target - 1) + jumpFloor(target - 2)
    }
}

fun jumpFloor2(target: Int): Int {
    return when (target) {
        in 1..2 -> target
        else -> {
            var a = 1
            var b = 2
            var n = target
            while (n-- > 2) {
                b += a
                a = b - a
            }
            b
        }
    }

}