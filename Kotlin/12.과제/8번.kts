//두개의 리스트와 n번째 값을 넣어주면 각각의 리스트에서 n번째 값을 삭제하고 두개의 리스트를 합치는 함수 작성하시오

fun grouping(
    group1: MutableList<String>,
    group2: MutableList<String>,
    num: Int
): MutableList<MutableList<String>>? {
    if (num > group1.size || num > group2.size) {
        return null
    } else {
        group1.removeAt(num)
        group2.removeAt(num)
        val endList = mutableListOf<MutableList<String>>(group1, group2)
        return endList
    }
}
//MutableList<>    ,,  mutableListOf(...) 차이좀 제대로 알아야 할듯
val soldiers =
    grouping(mutableListOf<String>("A", "B", "C", "D", "E"), mutableListOf<String>("A", "B", "C"), 1)
println(soldiers)