val numbers = intArrayOf(5, 10, 15)
for (i in numbers) {
    println(i)
}
for ((index, number) in numbers.withIndex()) {
    println(index)
    println(number)
}

for (i in 0 until numbers.size) {
    println(numbers[i])
}
for (i in numbers.indices) {
    println(i)
}

numbers.forEach { number ->
    println(number)
}
numbers.forEachIndexed { index, value ->
    println(index)
    println(value)
}