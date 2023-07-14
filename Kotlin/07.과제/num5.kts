fun nullableSum(num1: Int?, num2: Int?): Int { //value!!!!!!
    //함수에서 받은 인자는 val이다!!
    val first: Int = if (num1 == null) 0 else num1
    val second: Int = if (num2 == null) 0 else num2
    return first + second
}

val result: Int = nullableSum(null, null)
print(result)