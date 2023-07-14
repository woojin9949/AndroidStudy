//두개의 주사위를 던졌을때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 함수를 만드시오

fun diceSumSix(): Unit {
    var list1 = mutableListOf<List<Int>>()
    for (i in 1..6) {
        for (j in 1..6) {
            if (i + j == 6) {
                val list2 = listOf<Int>(i, j)
                list1.add(list2)
                //list1.add(listOf<Int>(i,j))
            }
        }
    }
    println(list1)
}
diceSumSix()
