val number: Int? = null  //null이 들어갈 수 있는 변수 -> nullable
//val number2: Int = null //null이 들어갈 수 없는 변수 -> non-null
val number2: Int = 3 + 5
val number3: Int = 10
val number4: Int = number2 + number3

val num2: Int? = 3 + 5
val num3: Int? = 10
val num4: Int? = num2 + num3
println(num4)
//변수 값들이 null일 수도 있고, 자료형일 수도있다
//컴퓨터는 안믿는거다.
val num5: Int? = 3 + 5
val num6: Int? = 10
val num7: Int? = num5!! + num6!!
println(num7)
//해결하기위해선 !!를 추가함으로써 개발자가 보장!!
//But null이 있을경우 NullPointerException발생!!
//결론: 웬만해서 100퍼센트 확신하는거 아니면 쓰지말자!!

//null은 비교연산은 가능하다!! 상태의 의미도 있다!! 값뿐만 아니라
//ex)(null==5) always false || (null==null) always true



