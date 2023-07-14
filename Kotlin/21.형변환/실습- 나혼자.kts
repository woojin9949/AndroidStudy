class Monster(var name: String, var hp: Int, var mp: Int) {
    fun attack(beginner: Beginner) {
        beginner.hp -= 10
        println("몬스터 공격실행")
    }
}

open class Beginner(var name: String, var hp: Int, var mp: Int, var exp: Int) {
    open fun attack(monster: Monster) {
        println("전사 공격실행")
        monster.hp -= 10
        if (monster.hp <= 0) {
            exp += 10
        }
    }
}

open class Soldier(name: String, hp: Int, mp: Int, exp: Int) : Beginner(name, hp, mp, exp) {
    override fun attack(monster: Monster) {
        super.attack(monster)
    }

    fun runToYou() {
        println("뎀프시롤")
    }
}

class SwordSoldier(name: String, hp: Int, mp: Int, exp: Int) : Soldier(name, hp, mp, exp) {
    override fun attack(monster: Monster) {
        super.attack(monster)
    }

    fun powerStrike(monster: Monster) {
        if (mp < 20) {
            println("마나 부족!!")
            return
        } else {
            println("전사 특수공격 실행")
            mp -= 20
            monster.hp -= 20
            if (monster.hp <= 0) {
                exp += 10
            }
        }
    }
}

fun main() {
    val soldier: Soldier = SwordSoldier("용감한용사", 100, 100, 0)
    println("전사 정보:" + soldier.name + " 체력:" + soldier.hp + " 마나:" + soldier.mp + " 경험치:" + soldier.exp)
    println("-------------------------------")
    val monster = Monster("초록달팽이", 20, 10)
    println("몬스터 정보:" + monster.name + " 체력:" + monster.hp + " 마나:" + monster.mp)
    soldier.attack(monster)
    println("몬스터 정보:" + monster.name + " 체력:" + monster.hp + " 마나:" + monster.mp)
    monster.attack(soldier)
    soldier as SwordSoldier
    soldier.powerStrike(monster)
    println("전사 정보:" + soldier.name + " 체력:" + soldier.hp + " 마나:" + soldier.mp + " 경험치:" + soldier.exp)
    println("몬스터 정보:" + monster.name + " 체력:" + monster.hp + " 마나:" + monster.mp)
}

main()