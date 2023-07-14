//1.문자열을 직접 전달하는 방법
println("안녕하세요")

//2. 변수를 출력하는 방법 $사용!!
val name = "이름"
val myName = "홍길동"

println("내 $name 은 $myName 입니다.")

val number1 = 10
val number2 = 100

println("$number1 더하기 $number2 는 ${number1 + number2}")

//특수 문자 출력하는 방법
println("\$myName")   // \를 사용하는 방법
println("${"myName"}")  //${}를 사용하는 방법

println("" + number1 + " 더하기 " + number2 + "는" + " ${number1 + number2}")  //빈 문자열이 필요하다.
//println("안녕하세요"+10)은 가능 But (10+"안녕하세요") 이건 안됨
//다른 타입 + 문자열 은 Error
//문자열 + 다른타입 은 OK