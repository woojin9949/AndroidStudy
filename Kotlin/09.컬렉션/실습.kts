//List
val numbers = listOf<Int>(1, 2, 3)  //immutable
//println(numbers)
println(numbers.get(1))
println(numbers.indexOf(1))
println(numbers.last())
val numbers2 = mutableListOf<Int>(1, 2, 3)  //mutable
numbers2.add(50)
numbers2.removeAt(1)
println(numbers2)
numbers2.addAll(2, listOf<Int>(100, 100))
println(numbers2)

//Set
val numbers3 = setOf<Int>(1, 2, 3, 4, 4, 4, 5)
println(numbers3.contains(2))
println(numbers3.containsAll(setOf<Int>(1, 2, 3, 4)))
val numbers4 = mutableSetOf<Int>(1, 2, 3, 4, 4, 5, 6)
numbers4.remove(1)
println(numbers4)
//println(numbers3)

//Map
val numbers5 = mapOf<Int, String>(1 to "one", 2 to "two")
println(numbers5.keys)
println(numbers5.values)
println(numbers5.get(1))
println(numbers5.getOrDefault(3,"default"))
val numbers6 = mapOf<Int, String>(Pair(1, "one"), Pair(2, "two"))
//println(numbers5)
println(numbers6)


