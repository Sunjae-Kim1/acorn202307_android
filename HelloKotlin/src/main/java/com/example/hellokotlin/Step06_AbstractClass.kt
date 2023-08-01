package com.example.hellokotlin

// 추상 클래스 => Abstract 예약어를 이용해서 만든다.
abstract class Weapon{
    fun move(){
        println("이동합니다.")
    }

    // 추상 메소드 역시 Abstract 예약어를 이용해서 만든다.
    abstract fun attack()
}

class MyWeapon : Weapon(){

    // 추상 메소드를 강제로 Override 해야 한다.
    override fun attack() {
        println("무언가를 공격합니다.")
    }
}

fun main(){
    val w1 : Weapon = MyWeapon()
    w1.move()
    w1.attack()

    val w2 : Weapon = object : Weapon(){
        override fun attack() {
            println("공중 공격을 합니다")
        }
    }
    w2.move()
    w2.attack()

    println("----------------------------------------------------")
    /*
        with( 참조값 ){

        }
        참조값을 가지고 ( 참조값과 함께 ) 여러가지 작업을 { } 안에서 한다.
    */
    with(w2){
        move()
        attack()
    }

    // 다형성
    val w3 = MyWeapon() // w3 에는 MyWeapon 객체의 참조값이 들어 있다.

    val a : MyWeapon = w3 // w3 에는 당연히 MyWeapon Type 이다.
    val b : Weapon = w3 // w3 에는 Weapon Type 이기도 하다
    val c : Any = w3 // Any Type 은 Java 에서 Object Type 에 해당하는 Type 이다.

    // Any Type 변수에는 어떤 Type 이든 담을 수 있다.
    var d : Any = 10
    d = true
    d = "kim"
    d = w3
}