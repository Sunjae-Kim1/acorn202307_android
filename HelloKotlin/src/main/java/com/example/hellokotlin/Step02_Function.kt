package com.example.hellokotlin

// Run 했을 때 실행의 흐름이 시작되는 main 함수 만들기
fun main(){
    println("main 함수가 시작했습니다.")

    /*
        in Java => public void a(){}
        in Kotlin => fun a():Unit{} or fun a(){}
        Kotlin 에서 Unit 은 원시 Type 이라고 지칭하고 Java 의 void 와 비슷하다.
    */

    // 함수 명(): 리턴 Type{}
    fun a():Unit{
        println("a 함수 호출")
    }

    a()

    // 이름이 없는 함수를 만들어서 그 참조값을 변수에 담기
    var b = fun(){}

    /*
        대입 연산자의 우측에 있는 함수를 보면
        리턴 Type : 없다 ( Unit )
        함수에 전달해야 하는 인자 : 없다
    */
    var c: () -> Unit = fun(): Unit{}
    c = fun():Unit{}
    c = fun(){}

    // 매개변수는 1 개 , Type 은 String , 리턴 Type 은 Unit ( 없다 )
    var d: (String) -> Unit = fun(String){}

    // 매개변수는 1 개 , Type 은 String , 리턴 Type 은 String
    var e: (String) -> String = fun(String):String{
        return "xxx"
    }

    // 매개변수는 2 개 , Type 은 Int , Int , 리턴 Type 도 Int
    var sum:  (Int , Int) -> Int = fun(a , b): Int{
        return a + b
    }

    var myName: String = "kim"
    var myNum: Int = 10

    println("main 함수가 종료했습니다.")
}