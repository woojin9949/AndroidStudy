//Range
val range1 = 1..10
println(range1)
val range2 = 1 until 10
println(range2)
val range3 = 'A'..'Z'
println(range3)
//Progression
val range4 = 1..10 step 2 //1,3,5,7,9
println(range4)
val range5 = 10 downTo 1 step 2
println(range5)

//Collection
val collection1 = listOf<Int>(1, 2, 3, 4, 5)  //list는 iterable이 포함되어있다.

for (i in 0 until collection1.size) {
    println(collection1.get(i))
}
collection1.forEach { println(it) }