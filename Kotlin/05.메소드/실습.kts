var number100: Int = 100

//리턴값 함수
fun plusNumbers(firstNum: Int, secondNum: Int): Int {
    val result: Int = firstNum + secondNum
    return result
}

val result: Int = plusNumbers(firstNum = 7, secondNum = 8)
println(result)

//기본값이 있는 함수
fun plusNumbersWithDefault(firstNum: Int = 10, secondNum: Int = 15): Int {
    return firstNum + secondNum
}

val result2: Int = plusNumbersWithDefault()
println(result2)
val result3: Int = plusNumbersWithDefault(firstNum = 20)
println(result3)
val result4: Int = plusNumbersWithDefault(firstNum = 20, secondNum = 50)
println(result4)

//반환값이 없는 함수
fun plusNumberWithNoReturn(firstNum: Int, secondNum: Int): Unit {
    val result = firstNum + secondNum
    println(result)
}
plusNumberWithNoReturn(100, 200)

fun plusNumberWithNoReturn2(firstNum: Int, secondNum: Int) {
    val result = firstNum + secondNum
    println(result)          //return이라는 키워드는 적어도 상관없음, 반환값만 없으면 된다.
    //return
}
plusNumberWithNoReturn2(100, 200)

//함수선언 간단하게 하는법
fun shortPlusNumbers(firstNum: Int, secondNum: Int) = firstNum + secondNum
var result10: Int = shortPlusNumbers(5, 6)
println(result10)

//가변인자를 갖는함수
fun plusMutipleNumbers(vararg numbers: Int): Unit {
    for (i in numbers) {
        println(i)
    }
}
plusMutipleNumbers(1, 2, 3, 4, 5)
