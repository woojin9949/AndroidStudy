fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

//고차함수
fun addTenNine(function: (Int, Int) -> Int) {
    val result: Int = function(10, 9)
    println("결과는$result 입니다.")
}

addTenNine(::addTwoNumbers)

//람다
//생략 없는 버전
//람다 함수 내에선 return 불가 마지막 라인이 return된다.
//풀버전
val addTenNine2: (Int, Int) -> Int = { number1: Int, number2: Int ->
    number1 + number2
}

addTenNine(addTenNine2)  //람다 함수를 인자로 받을 경우 ::을 쓸 필요 없다!!

//생략 버전 1
val addTenNine3: (Int, Int) -> Int = { number1, number2 ->    //자료형 타입 제외
    number1 + number2
}
addTenNine(addTenNine3)

//생략 버전 2
val addTenNine4 = { number1: Int, number2: Int ->
    number1 + number2
}
addTenNine(addTenNine4)
//간단한 경우
addTenNine { a, b -> a + b }

//파라미터 없는 람다 함수
val addTenNine5: () -> Int = {
    10 + 9
}

//고차 함수 예
fun funPrint(str: String, num: Int): String {
    val result: String = str + num
    return result
}

fun highOrder(str: String, function: (String, Int) -> String) {
    val result: String = str + function("답:", 10)
    println(result)
}

highOrder("1번", ::funPrint)

val funPrint1: (String, Int) -> String = { str: String, num: Int ->
    str + num
}
highOrder("2번", funPrint1)

val funPrint2: (String, Int) -> String = { str, num ->
    str + num
}
highOrder("3번", funPrint2)

val funPrint3 = { str: String, num: Int ->
    str + num
}
highOrder("4번", funPrint3)

highOrder("5번", { str, num -> str + num })