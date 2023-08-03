package com.example.hellokotlin

/*
    어떤 데이터를 Index 로 관리를 하고 ReadOnly 로 사용한다면
    List 를 사용하면 된다.
*/
fun main(){
    val names: List <String> = listOf<String>("kim" , "lee" , "park")

    // Value 의 Genric 이 추론이 가능하기에 생략 가능
    // names2 의 Type 이 추론이 가능하기에 생략 가능
    val names2 = listOf("kim" , "lee" , "park")

    val nums: List<Int> = listOf(10 , 20 , 30)
    val info: List<Any> = listOf(10 , "kim" , true)

    // names List 의 0 번 Index 참조하는 방법 1
    val a = names.get(0)

    // names List 의 0 번 Index 참조하는 방법 2
    val b = names[0]

    // names 의 Item 객수 참조
    val c = names.size

    // names 에 저장된 Item 을 순서대로 순회하면서 참조
    names.forEach(fun (item){
        println(item)
    })
    println("------------------------------------------------")

    // 위의 forEach() 함수를 줄인 표현으로 사용하면 아래와 같다
    names.forEach(){
        println(it)
    }

    // List 의 Index 들만 모아놓은 IntRange Type 얻어내기
    val result: IntRange = names.indices

    // for 문에서 Index 를 하나씩 참조해 보기
    for(index in result){
        println(index)
    }
    println("-------------------------------------------------")
    for(index in names.indices){
        println("$index: ${names[index]}")
    }
    println("List 의 Item 을 역순으로 참조하고 싶다면")
    for(index in 2 downTo 0){
        println(names[index])
    }
    println("위의 코드를 일반화 시키면")
    for(index in names.lastIndex downTo 0){
        println(names[index])
    }
}