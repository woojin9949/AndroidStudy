//getter setter
class Book() {
    var title: String = "모름"
        get() {
            println("getter")
            return field
        }
        set(value) {
            println("setter")
            field = value
            //title = value 이러면 안된다 setter에서는 불가 무조건 field

        }
}

/*var book = Book()
println(book.title)
book.title = "제목 변경"
println(book.title)*/
//lateinit은 초기화가 되어 있을 수 있고 안되어 있을 수 있다
class Book2() {
    lateinit var title: String  //초기화 하지말기

    fun nextPage() {
        if (::title.isInitialized) {
            println("페이지가 넘어간다.")
            println(this.title)
        } else {
            println("초기화 필요")
        }
    }
}

val book = Book2()
book.title = "레이트이닛"
println(book.nextPage())

val book2 = Book2()
println(book2.nextPage())

// Lazy
// -호출시점에 by lazy 정의에 의해 초기화 수행
// -val 에서만 사용 가능하다
// 추후에서라도 사용자가 사용할때는 무조건 초기화 되어있다
class Book3 {
    val title: String by lazy {  //람다식
        //본문 -> 다른 작업도 할 수 있지만 반드시 초기화 작업을 해야한다.
        println("lazy 초기화")
        //title = "해리포터" -> 불가능
        //return "해리포터" -> 불가능
        "해리포터"  //람다식은 return 키워드 사용 불가
    }
}
//여러개의 객체가 생성되어 있고 title이라는 변수를 특정 객체에서만 필요할때 사용하면 좋다 
//다 사용할 경우 메모리 낭비
val book3 = Book3()
println(book3.title)