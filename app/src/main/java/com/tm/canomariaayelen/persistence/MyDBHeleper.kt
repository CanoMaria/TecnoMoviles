package com.tm.canomariaayelen.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHeleper(context : Context) : SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL("CREATE TABLE USERS( USERID INTEGER PRIMARY KEY AUTOINCREMENT,USER VARCHAR(45),PASSWORD VARCHAR(45),NAME VARCHAR(45),EMAIL VARCHAR(100))")
        db?.execSQL("INSERT INTO USERS (USER,PASSWORD,NAME,EMAIL)VALUES('ayee','123','ayelen cano','ayecano98@gmail')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}