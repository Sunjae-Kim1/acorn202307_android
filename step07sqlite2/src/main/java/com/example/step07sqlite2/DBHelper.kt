package com.example.step07sqlite2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
/*
    1. SQLiteOpenHelper Class 는 추상 클래스이기에 춧아 메소드를 Override 해야 한다.
    2. DBHelper Class 의 대표 생성자에서 부모 생성자에 전달할 값을 받아야 한다.
    3. SQLiteOpenHelper Class 의 생성자에서 필요한 값을 전달해야 한다.
*/
class DBHelper constructor(
    context: Context? ,
    name: String? ,
    factory: SQLiteDatabase.CursorFactory? ,
    version: Int
): SQLiteOpenHelper(context, name, factory, version){
    init{

    }
    override fun onCreate(db: SQLiteDatabase?) {
        /*
            String sql = "CREATE TABLE todo" +
                " (num INTEGER PRIMARY KEY AUTOINCREMENT , " +
                " content TEXT , regdate TEXT)";

            db.execSQL(sql);
        */
        val sql = """
            CREATE TABLE todo
            (num INTEGER PRIMARY KEY AUTOINCREMENT , content TEXT , regdate TEXT)
        """.trimIndent()
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS todo")
        onCreate(db)
    }
}