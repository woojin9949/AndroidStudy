//오버로딩

class Sum {
    fun sum(): Int {
        return 10
    }

    fun sum(number1: Int): Int {
        return number1 + 10
    }

    fun sum(number1: Int, number2: Int): Int {
        return number1 + number2 + 10
    }
}

val sum = Sum()
println(sum.sum())
println(sum.sum(10))
println(sum.sum(10, 20))

//open을 적어줘야 함수가 오버라이딩 가능하게 된다.
open class Warrior1(var name: String, var power: Int, var type: String) {  //부모클래스, 슈퍼클래스
    open fun attack() {
        println("복잡한 코드 + 공격")
    }

    open fun getDefensePower(): Int {
        return 10
    }
}

//주 생성자가 슈퍼클래스 생성을 하는경우
class DefenseWarrior1 constructor(name: String, power: Int) :
    Warrior1(name, power, "고블린") {
    fun defense() {
        println("방어")
    }

    override fun attack() {
        println("간단한 코드 + 공격")
    }

    override fun getDefensePower(): Int {
        val defaultWarriorDefensePower: Int = super.getDefensePower()
        return defaultWarriorDefensePower + 5
    }
}

val defenseWarrior = DefenseWarrior1("홍길동", 100)
defenseWarrior.attack()