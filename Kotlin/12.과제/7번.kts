//총 먹어야할 밥 횟수, 현재까지 먹은 밥 횟수 두개를 받는 함수 작성,
//"밥을 먹었다" 한번 출력할때마다 1회 먹은것으로 간주, 배 부를때까지 밥을 먹어야한다. 배가 부를경우 "배가 부르다" 출력
//아무리 배불러도 최소 한번은 무조건 먹는다.
fun eatToFull(eat: Int, ate: Int) {
    var target: Int = ate
    do {
        println("밥을 먹었다.")
        if (target == eat) {
            println("배가 부르다")
            break
        }
        target++
    } while (eat >= target)
}
eatToFull(5, 2)