package com.example.hellokotlin
/*
    Kotlin 에서는 Null 이 가능한 Type 과 Null 이 불가능한 Type 이 구분되어 있다.
    Null 이 가능한 Type 데이터를 사용 ( 필드 참조 or 메소드 호출 ) 할떄는 추가해야 하는 문법이 있다.
*/

// null 이 가능한 매개 변수가 선언되어 있는 함수
fun send(msg: String?){
    // msg 가 Null 이 아니면 Length 를 참조해라
    val result = msg?.length

    // msg 는 확실히 Null 이 아니야 그냥 Length 를 참조해
    val result2 = msg!!.length
}
fun main(){
    var str: String = "abcde12345"
    var str2: String? = "abcde12345"

    // str = null // Null 대입 불가
    str2 = null // Null 대입 가능

    // 문자열의 길이를 안전하게 참조할 수 있다.
    val result: Int = str.length
    /*
        참조값 ?. 필드 참조 or 메소드 호출
        은 참조값이 Null 이 아닌 경우에 우측의 필드참조 or 메소드 호출을 수행하라는 의미
        만일 참조값이 Null 이면 필드참조나 메소드 호출을 하지 않고 Null 을 남긴다.
    */
    val result2 = str2?.length

    println("result: $result")
    println("result2: $result2")

    var str3: String? = null
    str3 = "안녕하세요"

    // 컴파일러가 Null 이 아닌 것을 확실히 인지한다면 ? 생략 가능
    val result3 = str3.length

    // 아래는 NullPointerException 발생
    send(null)
}