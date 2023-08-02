package com.example.hellokotlin

class Gun{
    fun prepare(){
        println("총을 발사할 준비를 합니다.")
    }
    fun fire(){
        println("Bang!!!!")
    }
    fun end(){
        println("마무리 합니다.")
    }
}

fun main(){
    val g1 = Gun()

    // 총을 여러번 쏘려면
    g1.fire()
    g1.fire()
    g1.fire()

    println("--------------------------------------")

    // 이미 만들어진 객체의 참조값을 여러번 사용하고 싶을 때 With 구문을 사용하면 된다
    with(g1){
        prepare()
        fire()
        fire()
        fire()
        end()
    }
}