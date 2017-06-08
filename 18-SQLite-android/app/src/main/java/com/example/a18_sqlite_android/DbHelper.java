package com.example.a18_sqlite_android;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbHelper  extends SQLiteOpenHelper {

    // Si cambia el diagrama de la base de datos, debe incrementar la version de la base de datos.

    //Versión de la Base de datos
    public static final int DATABASE_VERSION = 1;
    //Nombre de la base de datos
    public static final String DATABASE_NAME = "DatabaseSqlite.db";


    /*  Definir el esquema de la tabla
     *  Clase Interna que define el contenido de la Tabla
     **/
    public static class TablaPersona implements BaseColumns {

        public static final String TABLE_NAME = "persona";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNA_NOMBRES = "nombres";
        public static final String COLUMNA_TELEFONO = "telefono";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";

        private static final String SQL_CREATE_TABLA_PERSONAS =
                "CREATE TABLE " + TablaPersona.TABLE_NAME + " (" +
                        TablaPersona.COLUMNA_ID + " INTEGER PRIMARY KEY," +
                        TablaPersona.COLUMNA_NOMBRES + TEXT_TYPE + COMMA_SEP +
                        TablaPersona.COLUMNA_TELEFONO + TEXT_TYPE + " )";

        private static final String SQL_DELETE_TABLA_PERSONA =
                "DROP TABLE IF EXISTS " + TablaPersona.TABLE_NAME;
    }

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaPersona.SQL_CREATE_TABLA_PERSONAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TablaPersona.SQL_DELETE_TABLA_PERSONA);
        onCreate(db);
    }
}
