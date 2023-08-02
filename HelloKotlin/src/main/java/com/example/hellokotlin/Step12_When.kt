package com.example.hellokotlin

import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)
    println("Gun: 1, Sword: 2")
    println("무기 선택( 1 or 2 ): ")
    val weapon = scan.nextInt()

    // Weapon 안에 들어있는 숫자를 이용해서 분기하기
    when(weapon){
        1 -> println("총으로 공격합니다.")
        2 -> println("검으로 공격합니다.")
        else -> println("주먹으로 공격합니다.")
    }

    // When 구문도 리턴값을 가질 수 있다.
    val selectedWeapon = when(weapon){
        1 -> "총"
        2 -> "검"
        else -> "주먹"
    }

    println("선택한 무기: $selectedWeapon")
}