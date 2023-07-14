val number1: Int = 10
if (number1 == 10) {
    println("10임")
} else if (number1 == 20) {
    println("20임")
} else {
    println("둘다 아님")
}

if (number1 == 10) println("참") else println("거짓")

val number2: Int = 20
val number3: Int = if (number2 >= 20) 30 else 15
println(number3)

//if를 코틀린에서 식으로 처리하기때문에 13줄 처럼 처리가 가능하다!!!
//when 사용법!!
val number4: Int = 5
when (number4) {
    5 -> {
        println("5입니다.")
    }
    6 -> {
        println("6입니다.")
    }
    else -> {
        println("못찾겠습니다.")
    }
}
when (number4) {
    5 -> println("5입니다.")
    6 -> println("6입니다.")
    else -> println("못찾겠습니다.")
    "안녕하세요" -> println("hello")
    is Boolean -> println("boolean")
}
when (number4) {
    in 1..10 -> println("number is in 1..10")
    in 20..30 -> println("number is in 20..30")
}