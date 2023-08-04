package com.example.hellokotlin
/*
    [ Java 에서 배열 만드는 방법 2 가지 ]

    정수를 담을 수 있는 5 개의 방 배열을 만들기
    int[] nums = { 0 , 0 , 0, 0 , 0 };
    int[] nums = new int [5];

    문자열을 담을 수 있는 5 개의 방 배열 만들기
    String[] names = { null , null , null , null , null };
    String[] names = new String[5];
*/
fun main(){
    val nums = arrayOf(0 , 0 , 0 , 0 , 0)

    // Array<T>(방의 Size , 초기화 함수)
    val nums2 = Array<Int>(5 , {0})

    val names = arrayOf<String?>(null , null , null)
    val names3 = Array<String?>(3 , {null})

    val msgs = arrayOf("" , "" , "")
    val msgs2 = Array<String>(3 , {""})

    val msgs3 = Array(100){
        "메세지 $it"
    }
    for (item in msgs3){
        println(item)
    }
}