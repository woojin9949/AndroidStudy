for (i in 1..3) {
    for (j in 0 until i) {
        print("*")
    }
    println()
}
println("*************************")
//break
for (i in 1..3) {
    println("i : " + i)
    for (j in 1..3) {
        if (j == 2) break
        else println("j : " + j)
    }
}
println("*************************")
//continue
for (i in 1..3) {
    println("i : " + i)
    for (j in 1..3) {
        if (j == 2) continue
        else println("j : " + j)
    }
}
println("*************************")
fun returnFunction() {
    for (i in 1..3) {
        println("i : " + i)
        for (j in 1..3) {
            if (j == 2) return
            else println("j : " + j)
        }
    }
}
returnFunction()

println("*************************")
//라벨
loop@ for (i in 1..3) {
    println("i : " + i)
    for (j in 1..3) {
        if (j == 2) break@loop
        else println("j : " + j)
    }
}
println("*************************")
loop@ for (i in 1..3) {
    println("i : " + i)
    for (j in 1..3) {
        if (j == 2) continue@loop
        else println("j : " + j)
    }
}
//forEach는 continue, break 불가!!
listOf<Int>(1, 2, 3, 4).forEach loop@{
    if (it == 2) return@loop
    else println(it)
}