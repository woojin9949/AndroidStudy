interface Tiger {
    fun bite()
    fun goToBox()
}

class BackDoSanTiger : Tiger {
    override fun bite() {
        println("물어버린다.")
    }

    override fun goToBox() {
        println("집으로 들어간다.")
    }
}

val backdosanTiger: BackDoSanTiger = BackDoSanTiger()
backdosanTiger.bite()

interface Person {
    //멤버들의 구현부가 없다.
    var dress: String
    fun eat()
    fun sleep() {
        println("잠을 잔다.")
    }
}

class Student : Person {
    override var dress: String
        get() = "옷"
        set(value) {}

    final override fun eat() {
        // final -> 이 클래스를 상속한느 클래스에서 override를 못하게 한다.
        println("밥을 먹는다")
    }

    open fun study() {
        println("공부를 한다.")
    }

}

class GoodStudent : Student {

}

class Teacher : Person {
    override var dress: String
        get() = "정장"
        set(value) {}

    override fun eat() {
        println("밥을 먹는다")
    }

}

val student: Student = Student()
student.eat()
student.sleep()
student.study()