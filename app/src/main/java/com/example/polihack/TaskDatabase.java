package com.example.polihack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.webkit.ConsoleMessage;


public class TaskDatabase {
    myDbHelper myhelper;
    public TaskDatabase(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String Task, String pass)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.Task, Task);
        contentValues.put(myDbHelper.TaskId, pass);
        long id = dbb.insert(myDbHelper.TABLE_Task, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.Task, myDbHelper.TaskId};
        Cursor cursor =db.query(myDbHelper.TABLE_Task,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String Task =cursor.getString(cursor.getColumnIndex(myDbHelper.Task));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.TaskId));
            buffer.append(cid+ "   " + Task + "   " + password +" \n");
        }
        return buffer.toString();
    }

    public  int delete(String uTask)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uTask};

        int count =db.delete(myDbHelper.TABLE_Task , myDbHelper.Task+" = ?",whereArgs);
        return  count;
    }

    public int updateTask(String oldTask , String newTask)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.Task,newTask);
        String[] whereArgs= {oldTask};
        int count =db.update(myDbHelper.TABLE_Task,contentValues, myDbHelper.Task+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_Task = "myDatabase";    // Database Task
        private static final String TABLE_Task = "myTable";   // Table Task
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String Task = "Task";    //Column II
        private static final String TaskId= "Reward_Coins";    // Column III
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_Task+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Task+" VARCHAR(255) ,"+ TaskId+" VARCHAR(225) );";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_Task;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_Task, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
            }
        }
    }
}