package br.com.uniceub.android

class Usuario(private val conexaoDB: ConexaoDB) {

    fun getAllUserNames(): List<String> {
        val db = conexaoDB.readableDatabase
        val nomes = mutableListOf<String>()

        // Executa a query para selecionar todos os nomes de usuários
        val cursor = db.rawQuery("SELECT nome FROM TB_Usuario", null)

        // Itera pelo cursor e adiciona cada nome à lista
        if (cursor.moveToFirst()) {
            do {
                val nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
                nomes.add(nome)
            } while (cursor.moveToNext())
        }

        cursor.close() // Fecha o cursor para liberar recursos
        db.close()     // Fecha o banco de dados

        return nomes
    }
}