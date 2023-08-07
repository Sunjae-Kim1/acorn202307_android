package com.example.step08gameview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class GameView @JvmOverloads constructor(
    context: Context ,
    attrs: AttributeSet? = null
): View (context , attrs){

    lateinit var handler2: Handler

    // 사용할 필드 미리 만들기
    lateinit var backImg: Bitmap
    lateinit var unit1: Bitmap

    // 화면 폭 , 넓이를 저장할 필드
    private var width = 0
    private var height = 0

    // 배경 이미지 Y 좌표
    var back1Y = 0
    var back2Y = 0

    // 유닛의 크기
    var unitSize = 0

    // 유닛의 좌표
    var unitX = 0
    var unitY = 0

    // 게임 화면을 준비하는 함수
    fun init() {
        // 사용할 이미지를 미리 로딩해서 참조값을 필드에 저장하기
        // 원본 이미지
        var backImg: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.backbg)
        var unit1: Bitmap = BitmapFactory.decodeResource(resources , R.drawable.unit1)

        // 원본 이미지를 원하는 크기로 변경해서 필드에 저장
        this.backImg = Bitmap.createScaledBitmap(backImg, width, height, false)
        this.unit1 = Bitmap.createScaledBitmap(unit1 , unitSize , unitSize , false)

        // Handler 객체를 init 블럭에서 생성해서 참조값을 필드에 넣어둔다.
        handler2 = object : Handler() {
            //Handler 객체에 메세지가 도착하면 호출되는 메소드
            override fun handleMessage(msg: Message) {
                //화면 갱신하기
                invalidate()
                // handler 객체에 빈 메시지를 20/1000 초 이후에 다시 보내기
                sendEmptyMessageDelayed(0, 10)
            }
        }
        // handler 객체에 빈 메시지를 한 번 보내기
        handler2.sendEmptyMessageDelayed(0, 20)
    }

    // onDraw() 메소드에서 화면 구성
    override fun onDraw(canvas: Canvas?) {
        // 배경 이미지 , 유닛 이미지 , 적 이미지 등등 그리기
        canvas?.drawBitmap(backImg , 0f , back1Y.toFloat() , null)
        canvas?.drawBitmap(backImg , 0f , back2Y.toFloat() , null)

        canvas?.drawBitmap(unit1 , (unitX - unitSize / 2).toFloat() , (unitY -unitSize / 2).toFloat() , null)
        // 배경 이미지 관련 처리
        back1Y += 5
        back2Y += 5

        // 만일 배경1의 좌표가 아래로 벗어난다면
        if(back1Y >= height){
            // 배경 1를 상단으로 다시 보낸다.
            back1Y = -height

            // 배경2와 오차가 생기지 않게 복원
            back2Y = 0
        }

        // 만일 배경2의 좌표가 아래로 벗어난다면
        if(back2Y >= height){
            // 배경 2를 상단으로 다시 보낸다.
            back2Y = -height

            // 배경1와 오차가 생기지 않게 복원
            back1Y = 0
        }
    }

    // View 가 차지하고 있는 영역의 Width , Height 가 전달되는 메소드
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // 전달되는 폭 , 넓이를 필드에 저장
        width = w
        height = h

        // 배경 이미지의 초기 좌표
        back2Y = -height

        // unitSize 는 화면의 폭의 1/5 로 설정
        unitSize = w / 5

        // 유닛의 초기 좌표
        unitX = w / 2
        unitY = height - unitSize / 2

        // 초기화 함수 호출
        init()
    }

    // View 에  터치 이벤트가 발생하면 호출되는 함수
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_MOVE -> {
                unitX = event.x.toInt()
            }
        }
        return true
    }
}