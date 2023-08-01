package com.example.hellokotlin

// Kotlin 에서 Interface 만들기
interface Remocon{
    fun up()
    fun down()
}

// Interface를 구현한 클래스 만들기
class MyRemocon : Remocon{
    override fun up() {
        println("무언가를 올려요!")
    }

    override fun down() {
        println("무언가를 내려요!")
    }
}

fun main(){
    val r1 = MyRemocon()
    r1.up()
    r1.down()

    /*
        in Java
            Remocon r = new Remocon(){
                @Override
                public void up(){}
                @Override
                public void down(){}
            };

        in Kotlin
    */
    // 클래스를 정의함과 동시에 객체를 생성하는 것이 Object 키워드
    val r2 : Remocon = object : Remocon{
        override fun up() {
            println("채널을 올려요!")
        }

        override fun down() {
            println("채널을 내려요!")
        }
    }
    r2.up()
    r2.down()
}