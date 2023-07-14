//시험성적 리스트 score와 같은 크기의 배열을 만들고 80점 이상일 경우 true 아니면 false를 담는 배열을 나오게 하는 함수를 만드시오.
val score = intArrayOf(70, 71, 72, 77, 78, 79, 80, 82, 90, 99)
fun passOrFalse(): Array<Boolean> {
    var result = Array<Boolean>(10, { true })
    score.forEachIndexed { index, i ->
        if (i >= 80) result[index] = true
        else result[index] = false
    }
    return result
}

val result = passOrFalse()
result.forEach {
    println(it)
}
