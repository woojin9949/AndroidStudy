class Calculator constructor(initialNum: Int = 0) {
    var result: Int = initialNum
        set(value) {
            field = value
            println("계산: $field")
        }

    fun calculate(operator: Char, operand: Int) {
        when (operator) {
            '+' -> result += operand
            '-' -> result -= operand
            '*' -> result *= operand
            '/' -> result /= operand
            else -> println("잘못된 연산 입니다.")
        }
    }
}

val calculator = Calculator()
calculator.calculate('+', 10)
calculator.calculate('-', 19)
calculator.calculate('&', 10)
val calculator2 = Calculator(5)
calculator2.calculate('*', 10)