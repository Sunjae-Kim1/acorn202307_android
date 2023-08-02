package com.example.hellokotlin

class StarBucks{
    // null 이 가능한 String Type 필드
    var location: String? = null
        set(value) { // 필드에 값을 넣어줄 때 실행되는 블럭

            // Field 는 Location 을 가리키고 Value 는 넣을 값을 가리킨다.
            field = value + " 지점"
        }
        get() {
            if (field == null){
                return "지점 명 없음"
            }else{
                return field
            }
        }
}

fun main(){
    val s1 = StarBucks()
    s1.location = "강남"
    println(s1.location)

    val s2 = StarBucks()
    println(s2.location)
}