package com.example.hellokotlin

class Cat constructor(){
    // init 블럭은 Primary 생성자의 일부
    init {
        println("고양이가 생겼습니다.")
    }

    // 뒤늦은 초기화가 가능한 필드 lateinit 예약어 붙여서 선언하기
    lateinit var name: String

    // this() Primary 생성자를 호출하는 표현식이다.
    constructor(name: String) : this() {
        println("고양이의 이름은: ${name}")
        this.name = name
    }
}

class Dog constructor(){
    init{
        println("강아지가 생겼습니다.")
    }
    // 필드
    // null 값을 허용하고 싶으면 Type 뒤에 ? 를 붙인다.
    var name: String? = null
    constructor(name: String): this(){
        // null 이 가능한 Type 공간에 null 이 불가능한 Type 공간에 담긴 값을 대입하는 것은 가능
        this.name = name
    }
}

fun main(){
    val c1 = Cat("톰 캣")
    val c2 = Cat()

    println(c1.name)

    // lateinit 필드에 값을 넣어주고
    c2.name = "키티"

    // 필드를 참조해야 한다.
    println(c2.name)

    // null 값이 가능한 Data Type 은 Type 뒤에 ? 를 붙여 주어야 한다.
    // String Type 과 String ? Type 은 다른 Type 으로 간주
    // var myName: String = null
    var myName: String? = null

    myName = "김구라"
    myName = null

    // Int ( 숫자 ) Type 도 Null 을 넣어 놓고 값을 나중에 대입 가능
    var myNum: Int? = null
    myNum = 999
    myNum = null

    var d1  = Dog("바둑이")
    var d2 = Dog()

    println(d1.name)
    println(d2.name)
}