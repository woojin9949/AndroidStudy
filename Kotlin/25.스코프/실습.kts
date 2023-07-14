class Person(var name: String? = null, var age: Int? = null) {}

//apply
// -적용하다
// -객체를 초기화할때 사용하면 좋다
// 객체가 아직 생성이 되지 않았다
val gildong = Person().apply {
    name = "길동"
    age = 20
}
// apply를 사용 안할 시에 이렇게 하면 됨 간추리기 위함
val gildong = Person()
gildong.name = "길동"
gildong.age = 20

// also
// 유효성 검사 할때 좋음
// 수신된 객체의 속성을 변경하지 않고 사용할때
// 객체가 이미 만들어 지고 난뒤 
val gildong2 = Person("victor").also {
    //nameIsGildong(it.name)
}

//run
// - 기본적으로 apply와 동일하다
// - 스코프 마지막줄을 리턴한다 -> 특정 계산결과가 필요한경우
val ageAfter10year = Person("gildong", 10).run {
    age!! + 10
}
println(ageAfter10year)

val ageAfter10year2 = with(Person("gildong", 10)) {
    age!! + 10
}
// - with는 nullable 타입을 받지 못한다
println(ageAfter10year2)

// let
// - 기본적으로 also와 동일하다
// - 스코프의 마지막줄을 리턴한다
val gildong5 = Person("victor").let {

}