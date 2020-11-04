package com.example.idutut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button _btnThem, _btnSua ,_btnXoa;
    EditText _txtID, _txtName ,_txtAdd , _txtPhone , _txtEmail;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnThem=(Button)findViewById(R.id.btn_them);
        _btnXoa=(Button)findViewById(R.id.btn_xoa);
        _btnSua=(Button)findViewById(R.id.btn_sua);
        _txtID=(EditText)findViewById(R.id.edt_id);
        _txtName=(EditText)findViewById(R.id.edt_name);
        _txtAdd=(EditText)findViewById(R.id.edt_address);
        _txtPhone=(EditText)findViewById(R.id.edt_phone);
        _txtEmail=(EditText)findViewById(R.id.edt_email);
        openHelper=new DatabaseHelper(this);
        _btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= _txtName.getText().toString();
                String address=_txtAdd.getText().toString();
                String phone= _txtPhone.getText().toString();
                String email= _txtEmail.getText().toString();
                db=openHelper.getWritableDatabase();
                Toast.makeText(getApplicationContext(), "THÊM THÀNH CÔNG ", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void InsertData(String name, String address, String phone, String email){
        ContentValues contentValues= new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, name);
        contentValues.put(DatabaseHelper.COL_3, address);
        contentValues.put(DatabaseHelper.COL_4, phone);
        contentValues.put(DatabaseHelper.COL_5, email);
    }
}