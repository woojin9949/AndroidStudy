//1부터 100까지의 수 중에서 7의 배수의 합을 구하는 함수를 구하시오
fun multiple7(): Unit {
    var sum: Int = 0;
    for (i in 1..100) {
        if (i % 7 == 0) sum += i
    }
    println("7의배수의 합: " + sum)
}
multiple7()