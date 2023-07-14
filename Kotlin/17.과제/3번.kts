class Calculator constructor() {
    var result: Int = 0
        set(value) {
            field = value
            println(field)
        }

    fun calculate(operators: List<Char>, inputNumbers: List<Int>) {
        operators.forEachIndexed { index, operator ->
            _calculate(operator, inputNumbers[index])
        }
    }

    fun _calculate(operator: Char, operand: Int) {
        when (operator) {
            '+' -> result += operand
            '-' -> result -= operand
            '*' -> result *= operand
            '/' -> result /= operand
            else -> println("잘못된 연산 입니다.")
        }
    }
}
//map으로 만들경우 key값이 같을 경우 안된다

val calculator = Calculator()
calculator.calculate(listOf<Char>('+', '-'), listOf<Int>(15, 10))