package com.example.dicionario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DictDbHelper extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "dicionario.db";
    private static  final int VERSAO_BANCO = 3;

    public  DictDbHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + DictDbContract.DictEntry.NOME_TABELA
                +"(" + DictDbContract.DictEntry._ID + " INTEGER PRIMARY KEY,"
                + DictDbContract.DictEntry.COLUNA_PALAVRA + " TEXT,"
                + DictDbContract.DictEntry.COLUNA_SINONIMO + " TEXT ) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS" + DictDbContract.DictEntry.NOME_TABELA;

        db.execSQL(sql);
        onCreate(db);
    }
}
