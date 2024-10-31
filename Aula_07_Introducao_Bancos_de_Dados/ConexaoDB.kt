package br.com.uniceub.android

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream


class ConexaoDB(c: Context) : SQLiteOpenHelper(c, "MyApplicationDatabase.db", null, 1)
{


    override fun onCreate(p0: SQLiteDatabase?) {
        // TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // TODO("Not yet implemented")
    }

    val dbPath: String

    init {
        dbPath = c.getDatabasePath("MyAppDatabase.db").path

        if (!checkIfDatabaseExists(c)) {
            copyDatabaseFromAssets(c)
        }
    }


    private fun checkIfDatabaseExists(c: Context): Boolean {
        val dbFile = File(this.dbPath)
        return dbFile.exists()
    }

    private fun copyDatabaseFromAssets(c: Context) {
        try {
            val inputStream: InputStream = c.assets.open("MyAppDatabase.db")
            val outputFile: File = File(this.dbPath)
            val outputStream: OutputStream = FileOutputStream(outputFile)

            val buffer = ByteArray(1024)
            var length: Int
            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }

            outputStream.flush()
            outputStream.close()
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }




}
