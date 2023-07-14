val numbers = listOf<Int>(1, 2, 3)
/*try {
    numbers.get(5)
} catch (exception: Exception) {
    println(exception)
}*/
try {
    numbers.get(5)
} catch (exception: ArrayIndexOutOfBoundsException) {
    println("예외 발생 A")
} catch (exception: Exception) {
    println(exception)
} finally{
    println("무조건 실행되는 부분")
}