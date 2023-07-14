//구구단 입력받은 숫자의 해당 단수 9개 작성

fun multiTable(num: Int) {
    val list1 = mutableListOf<Int>()
    for (i in 1..9) {
        list1.add(num * i)
    }
    println(list1)
}
multiTable(3)
