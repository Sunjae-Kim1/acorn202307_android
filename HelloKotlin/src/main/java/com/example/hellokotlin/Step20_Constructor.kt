package com.example.hellokotlin

class Human{
    val name: String
    // String Type 을 전달 받는 생성자
    constructor(name: String){
        this.name = name
    }
}

// 위의 Class 를 아래와 같은 형태로 정의 가능
class Human2 constructor(name: String){
    val name: String
    init {
        this.name = name
    }
}

// 위의 작업을 줄여서 쓰면 아래와 같다.
class Human3 constructor(val name: String){

}

// 위의 작업을 더 줄이면 아래와 같다.
class Human4(val name: String)

// 참조값을 출력 시 필드 안에 들어있는 내용을 확인 가능하게 해서 개발을 용의하게 하려면
data class Human5(val name: String) // data 키워드를 이용해서 클래스를 정의

fun main(){
    val h1 = Human("김구라")
    val h2 = Human2("해골")
    val h3 = Human3("원숭이")
    val h4 = Human4("주뎅이")
    val h5 = Human5("덩어리")

    println("h4: $h4")
    println("h5: $h5")
}