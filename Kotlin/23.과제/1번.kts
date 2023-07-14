class Monster(hp: Int, power: Int, def: Int) {
    var hp: Int = hp
    val power: Int = power
    val def: Int = def

    init {
        println("Monster생성")
        println("Monster 아직 살아 있습니다. 체력: $hp")
    }

    fun attack(warrior: Warrior) {
        if (this.hp <= 0) {
            println("Monster는 죽었습니다 못싸웁니다.")
            return
        } else {
            warrior.hp -= power
            println("Monster가 공격합니다.")
            if (warrior.hp <= 0) {
                println("Warrior가 죽었습니다.")
            } else {
                println("Warrior의 피가 ${warrior.hp} 남았습니다!")
            }
        }
    }
}

open class Warrior(hp: Int, power: Int, def: Int) {
    var hp: Int = hp
    val power: Int = power
    val def: Int = def
    var kill: Int = 0

    open fun attack(monster: Monster) {
        if (this.hp <= 0) {
            println("Warrior는 죽었습니다. 못싸웁니다.")
        } else {
            monster.hp -= power
            println("Warrior가 공격합니다.")
            if (monster.hp <= 0) {
                println("Monster가 죽었습니다")
                kill++
            } else {
                println("Monster가 아직 살아있습니다. 체력: ${monster.hp}")
            }
        }
    }
}

class Knight(hp: Int, power: Int, def: Int) : Warrior(hp, power, def) {
    override fun attack(monster: Monster) {
        if (this.hp <= 0) {
            println("Knight는 죽었습니다. 못싸웁니다.")
        } else {
            monster.hp -= power
            println("Knight가 공격합니다.")
            if (monster.hp <= 0) {
                println("Monster가 죽었습니다")
            } else {
                println("Monster가 아직 살아있습니다. 체력: ${monster.hp}")
            }
        }
    }
}

val warrior: Warrior = Warrior(40, 30, 30)
val monster: Monster = Monster(30, 20, 40)
val monster1: Monster = Monster(30, 20, 40)
val monster2: Monster = Monster(30, 20, 40)

while (warrior.kill <= 3) {
    monster.attack(warrior)
    warrior.attack(monster)
    warrior.attack(monster1)
    warrior.attack(monster2)
    if (warrior.kill == 3) {
        println("Knight 전직!!")
        break;
    }
}
