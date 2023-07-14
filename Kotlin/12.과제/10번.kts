//두개의 숫자 리스트를 입력받아 짝수와 홀수로 분리된 Map을 만드는 함수 작성

fun listToMap(list1: List<Int>, list2: List<Int>): Map<String, MutableList<Int>> {
    val oddList = mutableListOf<Int>()
    val evenList = mutableListOf<Int>()
    val bothMap = mapOf<String, MutableList<Int>>(Pair("홀수", oddList), Pair("짝수", evenList))
    list1.forEach {
        if (it % 2 == 0) {
            evenList.add(it)
        } else oddList.add(it)
    }
    list2.forEach {
        if (it % 2 == 0) {
            evenList.add(it)
        } else oddList.add(it)
    }
    return bothMap
}

val result = listToMap(listOf<Int>(1, 3, 4, 6, 7, 9), listOf<Int>(2, 7, 10, 9, 4))
println(result)