package ArithmeticCode.kotlin

/**
 * Created by Hy on 2019/11/25 20:45
 */
fun main(){
    println(Test11().NumberOf1(8))
    println(Test11().NumberOf1(7))
    println(Test11().NumberOf1(3))

    println(Test11().NumberOf2(8))
    println(Test11().NumberOf2(7))
    println(Test11().NumberOf2(3))
}

class Test11 {

    fun NumberOf1(n:Int):Int {
        var count = 0
        var flag = 1
        while (flag != 0) {
            if (n.and(flag) != 0){
                count++
            }
            //移位操作
            flag = flag.shl(1)
        }
        return count
    }

    fun NumberOf2(n:Int):Int {
        var m = n;
        var count = 0;
        while (m != 0) {
            count++
            m = m.and(m-1)
        }
        return count;
    }

}
