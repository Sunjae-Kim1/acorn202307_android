package com.example.step08gameview

data class Enemy(
    var x: Int = 0 , // X 좌표
    var y: Int = 0 , // Y 좌표
    var type: Int = 0 , // 적 Type , 0 은 Silver , 1 은 Gold
    var isDead: Boolean = false , // 화면에서 제거 여부
    var energy: Int = 0 , // 적 체력
    var imageIndex: Int = 0 // 적 이미지 Index ( 애니메이션 효과를 위해 )
)