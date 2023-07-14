//기본 자료형의 타입 캐스팅
val number: Int = 10
val numberString: String = number.toString()
println(numberString)

val stringToNumber: Int = numberString.toInt()
println(stringToNumber)

val numberF: Double = 10.5
val numberFString: String = numberF.toString()
val numberFInt: Int = numberF.toInt()
println(numberFString)
println(numberFInt)

//상속한 클래스간의 캐스팅
open class Warrior(var name: String, var power: Int, var type: String) {  //부모클래스, 슈퍼클래스
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}


class DefenseWarrior constructor(name: String, power: Int) : Warrior(name, power, "고블린") {
    fun defense() {
        println("방어")
    }
}

// is 
// - 타입 체크
// true, false가 리턴된다
// - 스마트 캐스팅을 해준다
// var은 불가능 -> val을 사용해야한다.
val warrior: Warrior = DefenseWarrior("방어형 전사", 100)
println(warrior.attack())

if (warrior is DefenseWarrior) {
    // 스마트 캐스팅
    // -> 내가 만든 warrior를 if문 안에서 defenseWarrior로 사용하게 해준다.
    warrior.defense()
}

// as
// 지정한 타입으로 캐스팅을 시도하고, 불가능한 경우에는 예외 발생
val warrior2: DefenseWarrior = warrior as DefenseWarrior
warrior2.defense()
warrior2.attack()
