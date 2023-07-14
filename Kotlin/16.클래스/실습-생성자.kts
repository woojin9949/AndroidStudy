// 클래스 선언하는 방법

class Person {}

//생성자
//- 주생성자
//- 클래스 이름 옆에 괄호로 둘러싸인 코드
//- 클래스를 통해서 객체를 만드는데 필요한 재료들 적어 준다
//        -재료이름(변수명): 재료 타입(변수 타입)
//  - 반드시 한개만 존재할 수 있다
//  - constructor 키워드 생략 가능
//주 생성자 -> 풀버전 (생략X)
class User1 constructor(name: String) {
    val userName: String

    init {   //초기화
        userName = name
        println(userName)
    }
}

val user = User1("김우진")

// 주생성자 -> init을 생략하는 방법

class User2 constructor(name: String) {
    val userName: String = name
}

val user2 = User2("김우진2")

// 주생성자 -> constructor 생략하는 방법
class User3(name: String) {
    val userName: String = name
}

val user3 = User3("김우진2")

// 주생성자 -> 생략할 수 있는 모든걸 생략하는 방법
class User6(val name: String) {

}

// 주생성자 -> 기본값
class User4(name: String = "김아무개") {
    val userName: String = name
}

val user4 = User4()

// 생성자에서 받는 속성이 여러개인 경우
class User5(age: Int, name: String) {
    val age: Int
    val name: String

    init {
        this.age = age  //자바 개념 this
        this.name = name
    }
}

val user5 = User5(25, "우진")
println(user5.age)
//  -user5.age -> user5의 age

// 부생성자 (Secondary Constructor)
// -constructor 키워드 생략 불가!!
// -주생성자에는 객체를 만들기 위한 필수 조건이 있다면, 부생성자에는 객체를 만들기 위한 옵션 조건있다.
// -부생성자에는 주생성자에서 필요한 조건을 포함하고 있어야 한다( 파라미터를 포함해야함)
class User7 constructor(name: String) {
    var age: Int = 0  //부생성자에서 초기화 할때 주생성자에서 미리 초기화 시켜놔야 한다.
    val name: String
    var nickName: String = ""

    init {
        this.name = name
    }

    // 부생성자는 클래스명 우측에 올 수 없다-> 클래스 본문에 있어야함
    constructor(name: String, age: Int) : this(name) {   //부생성자 뒤에 :this(주생성자의 매개변수)넣어야함
        this.age = age
    }

    //부생성자는 여러개 가능하다.
    constructor(name: String, age: Int, nickName: String) : this(name) {
        this.age = age
        this.nickName = nickName
    }
}

val user7 = User7("김우진3")
println(user7.name)
val user7_2 = User7("김우진4", 25)
println(user7_2.age)

//실행순서
//부생성자 호출 -> 부생성자 안에있는 주생성자 호출 -> init블록 호출 -> 부생성자 본문 실행
//클래스 속성에서 초기화를 시켜주지 않아도 되는 이유


//주 생성자가 없고 부 생성자만 있을경우 주 생성자 처럼 보인다.
//BUT 부생성자이다. 주 생성자가 없기 때문에 this()생성자를 통해 생성 위임을 할 필요없다.
//쓸 이유가 없긴 하다. 그냥 주생성자에 만들어버리면 그만.
class User8 {
    val age: Int
    val name: String

    constructor(age: Int, name: String) {
        this.age = age
        this.name = name
    }
}

val user8 = User8(10, "가가가")
println(user8.age)