// ?
val number: Int? = null //Nullable
val number: Int = 10  //Non-Nullable

// !!
val nullableNumberList: List<Int?> = listOf<Int?>(1, 2, 3, null, null)
val result: Int = 0
//nullableNumberList.forEach {
//    result + it!!
//}
// -> 정말 필요한 경우에만 사용 해야 한다

// ?. (safe call)
val text: String? = "text"
val text1: String? = null
println(text?.length)
println(text1?.length)

// !!.
//println(text1!!.length) -> NullPointerException

// as?
open class Warrior(var name: String, var power: Int, var type: String) {  //부모클래스, 슈퍼클래스
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}

//주 생성자가 슈퍼클래스 생성을 하는경우
class DefenseWarrior constructor(name: String, power: Int) {
    fun defense() {
        println("방어")
    }
}

val defenseWarrior: DefenseWarrior = DefenseWarrior("김우진", 100)
val warrior: Warrior = defenseWarrior as? Warrior
//println(warrior)

// ?: 엘비스 연산
val text2: String? = "123"
val nullText: String? = null

val len1: Int = if (text2 != null) text2.length else 0
val len2: Int = text2?.length ?: 0