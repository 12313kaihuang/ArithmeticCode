@file:Suppress("unused")

package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/27 9:36
 *
 * 数值的整数次方
 */
class Test12 {
}

fun Power(base: Double, exponent: Int): Double {
    if (base == 0.0) {
        return 0.0
    }
    if (exponent == 0) {
        return 1.0
    }
    if (base == 0.0 && exponent < 0) {
        throw RuntimeException("分母不能为0")
    }

    var result = 1.0
    var curBase = base
    var n = if (exponent >= 0) exponent else -exponent
    while (n != 0) {
        //最低（右）位为1
        if (n and 1 == 1) {
            result *= curBase
        }
        //每次右移之后 基数翻倍
        curBase *= curBase
        //右移
//        n = n.shr(1)
        n = n shr 1
    }
    return if (exponent > 0) result else 1 / result
}