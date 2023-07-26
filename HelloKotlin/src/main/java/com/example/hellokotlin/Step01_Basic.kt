package com.example.hellokotlin

/*
    [ Kotlin 기본 Data Type ]
    - Import 없이 바로 사용할 수 있는 Data type

    Byte , Short , Int , Long
    Float , Double
    Boolean , Char
    String
*/

/*
    var ( = 변수 )

    or  identifier: type = 대입 값

    val ( = 상수 )
*/

fun main(){
    // 정수를 담을 수 있는 num 이라는 이름의 변수를 만들어 10 대입
    var num: Int = 10

    // 실수를 담을 수 있는 num2 라는 이름의 변수를 만들어 10.1 대입
    var num2: Double = 10.1

    // myName 이라는 변수에 문자열 "김구라" 대입
    var myName: String = "김구라"

    // yourName 이라는 상수에 문자열 "해골" 대입
    val yourName: String = "해골"

    // 변수는 값 변경 가능
    myName = "누구게";

    // 상수는 값이 한번 결정되면 값 변경 불가
    // yourName = "원숭이";

    // Type 추론이 가능한 경우 Type 생략 가능
    var num3 = 30
    var ourName = "에이콘"
    var num4 = 10.1

    // 변수를 먼저 선언하고
    var num5: Int

    // 값을 나중에 넣을 수 있다.
    num5 = 50

    // 변수나 상수를 미리 만들고 값을 나중에 넣고 싶으면 반드시 Type 을 명시해야 한다.
    var num6: Int
    num6 = 60

    // 상수도 미리 만들고
    val P1: Float

    // 값을 나중에 대입할 수 있다.
    P1 = 3.14159f

    // 상수는 값이 한번 결정되면 값 변경 불가
    // P1 = 3.14f

    println("main() 함수가 종료합니다.")
}