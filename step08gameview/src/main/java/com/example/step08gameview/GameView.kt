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
import java.util.Random

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

    // Null 로 초기화괸 Bitmap 객체를 담을 수 있는 방 4개짜리 배열 객체 생성
    var unitImgs = arrayOfNulls<Bitmap>(4)

    // Dragon 이미지를 그릴 때 사용할 Index 값
    var unitIndex = 0

    var count = 0

    // 미사일 이미지를 저장할 객체
    val missImgs = arrayOfNulls<Bitmap>(3)

    // 미사일의 크기
    var missSize = 0

    // 미사일 객체를 담을 List
    val missList = mutableListOf<Missile>()

    // 미사일 속도
    var missSpeed = 0

    // 배열 안에 배열 ( 2차원 )
    var enemyImgs = Array(2){ arrayOfNulls<Bitmap>(2) }

    // 적 개체를 저장할 List
    var enemyList = mutableListOf<Enemy>()

    // 적의 X 좌표 5 개를 저장할 정수 배열
    var enemyX = IntArray(5)

    // 적을 우연히 만들기 위한  Randon 객체
    var ran = Random()

    // 적이 겹치지 않게 만들어지는 Count 값 ( 적이 겹쳐서 만들어지지 않기 위해 )
    var postCount = 0

    // 게임 화면을 준비하는 함수
    fun init() {
        // 사용할 이미지를 미리 로딩해서 참조값을 필드에 저장하기
        // 원본 이미지
        var backImg: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.backbg)

        var unit1: Bitmap = BitmapFactory.decodeResource(resources , R.drawable.unit1)
        unitImgs[0] = Bitmap.createScaledBitmap(unit1 , unitSize , unitSize , false)

        var unit2: Bitmap = BitmapFactory.decodeResource(resources , R.drawable.unit2)
        unitImgs[1] = Bitmap.createScaledBitmap(unit2 , unitSize , unitSize , false)

        var unit3: Bitmap = BitmapFactory.decodeResource(resources , R.drawable.unit3)
        unitImgs[2] = Bitmap.createScaledBitmap(unit3 , unitSize , unitSize , false)

        // 3 번 방에 2 번쨰 Dragon 이미지를 넣는다.
        unitImgs[3] = unitImgs[2]

        // 원본 이미지를 원하는 크기로 변경해서 필드에 저장
        this.backImg = Bitmap.createScaledBitmap(backImg, width, height, false)
        this.unit1 = Bitmap.createScaledBitmap(unit1 , unitSize , unitSize , false)

        // 미사일 이미지 로딩
        val missImg1 = BitmapFactory.decodeResource(resources, R.drawable.mi1)
        val missImg2 = BitmapFactory.decodeResource(resources, R.drawable.mi2)
        val missImg3 = BitmapFactory.decodeResource(resources, R.drawable.mi3)

        // 미사일 이미지 크기 조절
        missImgs[0] = Bitmap.createScaledBitmap(missImg1, missSize, missSize, false)
        missImgs[1] = Bitmap.createScaledBitmap(missImg2, missSize, missSize, false)
        missImgs[2] = Bitmap.createScaledBitmap(missImg3, missSize, missSize, false)

        // 적기 이미지 로딩
        val enemyImg1 = BitmapFactory.decodeResource(resources, R.drawable.silver1)
        val enemyImg2 = BitmapFactory.decodeResource(resources, R.drawable.silver2)
        val enemyImg3 = BitmapFactory.decodeResource(resources, R.drawable.gold1)
        val enemyImg4 = BitmapFactory.decodeResource(resources, R.drawable.gold2)

        // 적기 이미지 사이즈 조절
        enemyImgs[0][0] = Bitmap.createScaledBitmap(enemyImg1, unitSize, unitSize, false)
        enemyImgs[0][1] = Bitmap.createScaledBitmap(enemyImg2, unitSize, unitSize, false)
        enemyImgs[1][0] = Bitmap.createScaledBitmap(enemyImg3, unitSize, unitSize, false)
        enemyImgs[1][1] = Bitmap.createScaledBitmap(enemyImg4, unitSize, unitSize, false)

        // 적의 X 좌표를 구해서 배열에 저장
        for(i in 0 .. 4){
            enemyX[i] = unitSize / 2 + unitSize * i
        }

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

        // 반복문 돌면서 미사일 그리기
        for(tmp in missList){
            missImgs[0]?.let{
                canvas?.drawBitmap(it ,
                    (tmp.x - missSize / 2).toFloat() ,
                    (tmp.y - missSize / 2).toFloat() ,
                    null)
            }
        }


        unitImgs[unitIndex]?.let {
            // Dragon 이미지 그리기
            canvas?.drawBitmap(
                it ,
                (unitX - unitSize / 2).toFloat() ,
                (unitY -unitSize / 2).toFloat() ,
                null)
        }

        // 적 그리기
        enemyList.forEach{
            // it , 적 개체의 참조값을 tmp 에 대입해서 사용
            var tmp = it
            enemyImgs[tmp.type][tmp.imageIndex]?.let{
                canvas?.drawBitmap(it ,
                    (tmp.x - unitSize / 2).toFloat() ,
                    (tmp.y - unitSize / 2).toFloat() ,
                    null
                )
            }
        }

        // 카운트 값을 증가
        count++

        //  만일 Count 를 20 으로 나눈 나머지 값이 0 이라면
        if(count % 10 == 0) {
            // Dragon 애니메이션 관련 처리
            unitIndex++
            if (unitIndex == 4) { // 만일 존재하지 않는 Index 라면
                unitIndex = 0 // 처음으로 돌린다.
            }
        }

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
        // 미사일 관련 처리를 하는 함수 호출
        missileService()

        // 적 관련 처리를 하는 함수
        enemyService()
    }
    // 적 관련 처리를 하는 함수
    fun enemyService(){
        postCount++

        // 난수를 하나 얻는다. ( 0 ~ 19 사이 )
        val ranNum = ran.nextInt(20)
        if(ranNum == 10 && postCount > 15){
            postCount = 0

            // 적 5 개체 1 세트 만들어서 List 에 누적
            for(i in 0 until 5){
                val tmp = Enemy()
                tmp.x = enemyX[i]
                tmp.y = unitSize / 2 // 임시 Y 좌표
                tmp.type = ran.nextInt(2) // 적 Type 은 0 or 1 랜덤 부여
                tmp.energy = if(tmp.type == 0){50}else{100}

                // 만든 적을 List 에 누적
                enemyList.add(tmp)
            }
        }
    }

    // 미사일 관련 처리를 하는 함수
    fun missileService(){
        // 미사일 만들기
        if(count % 5 == 0){
            // 현재 Dragon 좌표 값으로 미사일 객체를 생성
            val missile = Missile(unitX , unitY)

            // List 에 누적시키기
            missList.add(missile)
        }
        // 미사일의 Y 좌표를 감소시켜서 위로 이동하게 한다.
        for(tmp in missList){
            // 미사일 속도만큼 Y 좌표 감소
            tmp.y -= missSpeed
        }
        // 위쪽으로 벗어난 미사일 제거
        for(i in missList.lastIndex downTo 0){
            missList[i]?.let {
                // 만일 미사일의 Y 좌표가 위쪽으로 벗어난 좌표라면
                if(it.y < -missSize / 2){
                    // List 에서 해당 Index 제거
                    missList.removeAt(i)
                }
            }
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

        // 미사일의 크기는 Dragon 크기의  1 / 4
        missSize = unitSize / 4

        missSpeed = height / 50

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