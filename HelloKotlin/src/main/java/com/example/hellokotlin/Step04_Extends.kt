package com.example.hellokotlin
/*
    클래스 선언 시 기본 값을 상속받지 못하게 되어 있다.
    마치 Java 에서 Final Class Phone{} 처럼...
    상속을 받을 수 있게 하려면 open 이라는 예약어를 붙여 준다.
*/
open class Phone{
    fun call(){
        println("전화를 겁니다.")
    }
}

open class HandPhone : Phone(){ // Phone 클래스를 상속 받기
    fun mobileCall(){
        println("이동 중에 전화를 걸어요!")
    }

    // 재정의 가능한 메소드로 만들려면 open 예약어를 붙인다.
    open fun takePicture(){
        println("100만 화소의 사진을 찍어요!")
    }
}

class SmartPhone : HandPhone(){
    fun doInternet(){
        println("인터넷을 합니다.")
    }

    // override 라는 예약어를 이용해서 메소드를 override 가능
    override fun takePicture(){
        // 필요 시 부모의 메소드를 호출할 수 있다. ( Java 와 동일 )
        super.takePicture()
        println("1000만 화소의 사진을 찍어요!")
    }
}

fun main(){
    val p1 = Phone()
    val p2 = HandPhone()
    p1.call()

    // Phone 클래스를 상속 받은 클래스로 생성한 객체이므로 3개의 메소드 모두 사용 가능
    p2.call()
    p2.mobileCall()
    p2.takePicture()

    val p3 = SmartPhone()
    p3.doInternet()
    p3.takePicture()
}