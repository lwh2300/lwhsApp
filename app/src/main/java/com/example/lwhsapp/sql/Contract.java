package com.example.lwhsapp.sql;

import android.provider.BaseColumns;

public final class Contract {


    public static abstract class Entry implements BaseColumns{
        public final static String TABLE_NAME="user";
        public final static String COLLUMN_NAME_id="id";
        static String sql="CREATE TABLE user(id int primary key)";
    }
}
