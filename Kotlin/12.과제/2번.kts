//1부터 주어진 숫자까지의 합을 구하는 함수를 만들기
fun sumFunction(num: Int): Unit { //: Int
    var sum: Int = 0
    for (i in 1..num) {
        sum += i
    }
    //return sum
    println(sum)
}

sumFunction(10)
//val result: Int = sumFunction(10)
//println(result)