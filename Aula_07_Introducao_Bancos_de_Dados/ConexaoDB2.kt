package br.com.uniceub.android

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConexaoDB(c: Context) : SQLiteOpenHelper(c, "MyApplicationDatabase.db", null, 1)
{

  companion object {
        private const val DATABASE_NAME = "MeuBancoDeDados.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS Tabela_Inicial (
                ID INTEGER,
                Codigo INTEGER,
                Descricao TEXT
            );
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS Usuario (
                id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                login TEXT NOT NULL UNIQUE,
                senha TEXT NOT NULL
            );
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Aqui você pode lidar com atualizações de schema, se necessário no futuro
        db.execSQL("DROP TABLE IF EXISTS Tabela_Inicial")
        db.execSQL("DROP TABLE IF EXISTS Usuario")
        onCreate(db)
    }
}
    
}
