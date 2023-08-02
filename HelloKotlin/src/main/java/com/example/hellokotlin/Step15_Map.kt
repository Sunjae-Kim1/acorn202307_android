package com.example.hellokotlin

fun main(){
    // 수정 불가능한 Map    mapOf( Key to Value , Key to Value , ... )
    val mem: Map<String , Any> =
        mapOf<String , Any>("num" to 1 , "name" to "김구라" , "isMan" to true)

    // Map 에 저장된 데이터를 참조하는 방법 1
    val num: Any? = mem.get("num")
    val name: Any? = mem.get("name")
    val addr: Any? = mem.get("isMan")

    // Map 에 저장된 데이터를 참조하는 방법 2
    val num2: Int = mem["num"] as Int // Int Type 으로 Casting
    val name2: String = mem["name"] as String // String Type 으로 Casting
    val addr2: Boolean = mem["isMan"] as Boolean // Boolean Type 으로 Casting
}