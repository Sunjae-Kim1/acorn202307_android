package com.example.hellokotlin

// 함수 Type 을 매개변수로 전달받는 함수를 정의하고자 한다.
fun useFunc(a: () -> Unit){
    // 인자로 전달받은 함수 호출하기
    a()
}

fun main(){
    // 위의 useFunc() 함수를 호출하기
    useFunc (fun(){
        println("호출 완료1")
    })

    useFunc ({
        println("호출 완료2")
    })

    // 함수 호출하는 표현식 () 생략 가능
    useFunc {
        println("호출 완료3")
    }

    // Read Only 숫자 배열
    var nums: List<Int> = listOf(10 , 20 , 30)
    // nums[0] = 99 // nums 내부 item 은 변경 불가 , 하지만 nums 자체는 가능
    nums = listOf(100 , 200 , 300)

    nums.forEach(fun(item){
        println(item)
    })

    nums.forEach({
        // it 은 매개변수에 잔달되는 바로 그것 ( it ) 을 가리킨다
        println(it)
    })

    nums.forEach{
        // it 은 매개변수에 잔달되는 바로 그것 ( it ) 을 가리킨다
        println(it)
    }

    nums.forEach {}
}