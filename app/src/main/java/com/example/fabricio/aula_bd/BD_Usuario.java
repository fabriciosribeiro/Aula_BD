package com.example.fabricio.aula_bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Fabrício Ribeiro on 08/12/2017.
 */

public class BD_Usuario extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "usuario";
    private static final int VERSAO = 1;
    private static final String TAG = "usuario";

    public BD_Usuario(Context context){
        super(context, BANCO_DADOS, null, VERSAO);
        Log.i(TAG, "Ciando BD_Usuario");
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.i(TAG, "Criando tabela(s) do Banco de Dados");

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR(50), email VARCHAR(30), senha VARCHAR(40))");
            Log.i(TAG, "Tabela criada com sucesso");
        }catch (SQLException e){
            Log.e(TAG, "Falha durante a criação das tabelas: "+e);
        }

    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int versao_antiga, int versao_nova){
        //
    }

    public boolean salvarUsuario(String nome_usario, String email, String senha, BD_Usuario usuario){

        SQLiteDatabase banco = usuario.getWritableDatabase();

        // preparando valores a serem armazenados
        ContentValues valores = new ContentValues();
        valores.put("nome",nome_usario);
        valores.put("email",email);
        valores.put("senha",senha);

        // efetuando o INSERT INTO
        long resultado = banco.insert("usuario", null, valores);

        // verifica se o INSERT INTO foi realizado com sucesso
        if (resultado<0){
            Log.i(TAG, "Ocorreu um erro durante a inserção dos dados!");
            return false;
        }else{
            Log.i(TAG, "Dados inseridos com sucesso no banco de dados!");
            return  true;
        }


    }



}
