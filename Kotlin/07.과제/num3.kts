val score: Int = 68
fun scorePrint(score: Int): String {
    if (score >= 90) return "A"
    else if (score >= 80) return "B"
    else if (score >= 70) return "C"
    else return "F"
}

val result: String = scorePrint(score)
println(result)