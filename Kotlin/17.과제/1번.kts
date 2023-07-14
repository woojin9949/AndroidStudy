class calculator constructor() {
    var num: Int = 0
        set(value) {
            field = value
            println("계산:" + field)
        }

    fun plus(number: Int) {
        num += number
    }

    fun minus(number: Int) {
        num -= number
    }

    fun multi(number: Int) {
        num *= number
    }

    fun divide(number: Int) {
        num /= number
    }
}

val cal = calculator()
cal.plus(5)
cal.minus(3)
cal.multi(5)


