package br.com.uniceub.android

import android.content.ContentValues

class Log(private val conexaoDB: ConexaoDB) {

    fun logLoginAttempt(login: String, success: Boolean) {
        val db = conexaoDB.writableDatabase
        val timestamp = System.currentTimeMillis().toString()
        val tipo_log : Int
        val descrição: String

        if(success){
            tipo_log = 1
            descrição = "Login efetuado com sucesso"
        }
        else{
            tipo_log = 2
            descrição = "Login efetuado com sucesso"
        }

        val values = ContentValues().apply {
            put("id_tipo_log", tipo_log)
            put("login", login)
            put("descricao", descrição)
            put("data_hora", timestamp)
        }

        db.insert("TB_Log", null, values)
        db.close()
    }
}
