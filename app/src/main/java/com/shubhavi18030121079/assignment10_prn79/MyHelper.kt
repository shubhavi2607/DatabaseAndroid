package com.shubhavi18030121079.assignment10_prn79

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context): SQLiteOpenHelper(context,"ABCD",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE PInfo(pID VARCHAR, pName VARCHAR)")
        db?.execSQL("INSERT INTO PInfo VALUES ('1','First')")
        db?.execSQL("INSERT INTO PInfo VALUES ('2','Second')")
        db?.execSQL("INSERT INTO PInfo VALUES ('3','Third')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}