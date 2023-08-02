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

// 가상의 Dialog Class
class Dialog{
    fun setTitle(title: String){}
    fun setContent(content: String){}
    fun create(){}
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

    val d1 = Dialog()
    with(d1){
        setTitle("제목")
        setContent("내용")
        create()
    }

    // 객체 생성과 동시에 필요한 작업을 한 후에 참조값을 대입할 수 있다.
    val d2 = Dialog().apply {
        setTitle("제목")
        setContent("내용")
        create()
    }
}