package com.shubhavi18030121079.assignment10_prn79

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declaring variables
    lateinit var etID: EditText
    lateinit var etName: EditText
    lateinit var txtID: TextView
    lateinit var txtName: TextView
    lateinit var db: SQLiteDatabase
    lateinit var btnFirst : Button
    lateinit var btnNext : Button
    lateinit var btnPrev : Button
    lateinit var btnLast : Button
    lateinit var btnInsert : Button

    //OnCreate function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing Variables

        etID = findViewById(R.id.etID)
        etName = findViewById(R.id.etName)
        txtID = findViewById(R.id.txtID)
        txtName = findViewById(R.id.txtName)
        btnFirst = findViewById(R.id.btnFirst)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)
        btnLast = findViewById(R.id.btnLast)
        btnInsert = findViewById(R.id.btnInsert)

        db = openOrCreateDatabase("mydb", Context.MODE_PRIVATE, null)
        val tableQuery = "Create Table If Not Exists PInfo (eno VARCHAR, name VARCHAR)";
        db.execSQL(tableQuery)

        // Delete all records from the table
        /*val del = "DELETE FROM PInfo"
        db.execSQL(del)*/

        val cr = db.rawQuery("SELECT * FROM PInfo",null)

        //OnClick listener for First Button
        btnFirst.setOnClickListener {
            if (cr.moveToFirst()) {
                txtID.text = cr.getString(0)
                txtName.text = cr.getString(1)
            }
            else{
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_SHORT).show()
            }
        }

        //OnClick listener for Last Button
        btnLast.setOnClickListener {
            if (cr.moveToLast()) {
                txtID.text = cr.getString(0)
                txtName.text = cr.getString(1)
            }
            else{
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_SHORT).show()
            }
        }

        //OnClick listener for Next Button
        btnNext.setOnClickListener {
            if (cr.moveToNext()) {
                txtID.text = cr.getString(0)
                txtName.text = cr.getString(1)
            }
            else if(cr.moveToFirst()){
                txtID.text = cr.getString(0)
                txtName.text = cr.getString(1)
            }
            else{
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_SHORT).show()
            }
        }

        //OnClick listener for Previous Button
        btnPrev.setOnClickListener {
            if (cr.moveToPrevious()) {
                txtID.text = cr.getString(0)
                txtName.text = cr.getString(1)
            }
            else if(cr.moveToLast()){
                txtID.text = cr.getString(0)
                txtName.text = cr.getString(1)
            }
            else{
                Toast.makeText(applicationContext,"No Data Found",Toast.LENGTH_SHORT).show()
            }
        }

        //OnClick listener for Insert Button
        btnInsert.setOnClickListener{
            val s ="Insert into PInfo values ('" + etID.text.toString() + "','" + etName.text.toString() + "')"
            db.execSQL(s)
            //db.rawQuery("SELECT * FROM PInfo",null)
            cr.requery()
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show()
        }
    }
}