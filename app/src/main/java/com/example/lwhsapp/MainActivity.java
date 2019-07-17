package com.example.lwhsapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lwhsapp.dummy.DummyContent;
import com.example.lwhsapp.sql.Contract;
import com.example.lwhsapp.sql.SQLHelper;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener {

    public static final String EXTRA_CONTENT="com.example.lwhsapp.MainActivity.content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.addView,new Fragment2()).commit();

    }

    public void Send1(View view){
        SharedPreferences shareP=getSharedPreferences("", Context.MODE_PRIVATE);
//        SharedPreferences P=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=shareP.edit();
        editor.putString("key1","one");
        editor.commit();
        System.out.println(shareP.getString("key1","null"));
        Toast.makeText(this,shareP.getString("key1","blank"),Toast.LENGTH_LONG).show();
    }

    public void Send(View v){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(getExternalFilesDir(null)+"/sql.db",null);
        String sql=a();
        db.execSQL(sql);
        ContentValues V=new ContentValues();V.put("id",1);
        db.insert("user",null,V);
        String[] q={"*"};
        Cursor r=db.query("user",q,null,null,null,null,null);
        r.moveToFirst();
        System.out.println(r.getString(0));
    }

    private String a(){
        String sql="create table user(id integer primary key,name text)";
        return sql;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void toast(String str){
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }
}
