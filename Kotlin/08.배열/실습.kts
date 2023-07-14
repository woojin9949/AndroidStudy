//배열을 선언하는 방법(1)
var array1 = arrayOf(true, "HI", 10, 5.5, null)
var array2 = arrayOf<Int?>(1, 2, 3, 4, 5, null)
var array3 = intArrayOf(1, 2, 3, 4, 5)
//배열을 선언하는 방법(2)
var array4 = Array(10, { 0 })
println(array4.get(4))
println(array4[9])
var array5 = IntArray(10, { 0 })

var array6 = Array<Int>(10, { 0 })
var array7 = Array<String>(10, { "Hi" })

//array7.forEach { println(it) } Default값이 it 변겅 가능 forEach{ a -> println(a)}
var array8 = arrayOf<Int>(10, 20, 30, 40)
array8.set(0, 100)
array8[3] = 50
println(array8[0])

val examScore1: Int = 100
val examScore2: Int = 90
val examScore3: Int = 80

val array9 = arrayOf<Int>(examScore1, examScore2, examScore3)

val examScore4 = array9[0]
println(examScore4)