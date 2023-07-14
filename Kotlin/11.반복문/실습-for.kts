for (i in 1..10) {
    println("반복")
}
//Progression+ step
for (i in 0..5 step 2) {
    println("반복1")
}

for (i in 5 downTo 1) {
    println("반복2")
}

val numbers = listOf<Int>(5, 6, 7, 8)
for (i in 0..numbers.size) {//0..4
    println("반복~")
}

for (i in 0 until numbers.size) {  //0..3
    println("반복")
}
for ((index, number) in numbers.withIndex()) {
    println("" + index + " | " + number)
}
numbers.forEach { number ->
    println(number)
}