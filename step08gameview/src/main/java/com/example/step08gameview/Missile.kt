package com.example.step08gameview
/*
 미사일의 X 좌표 , Y 좌표 , 화면에서 제거할지 여부
*/
data class Missile(var x: Int , var y: Int , var isDead: Boolean = false)