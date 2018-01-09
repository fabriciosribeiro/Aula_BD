package com.example.fabricio.aula_bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.ListActivity;


public class ListaUsuario extends AppCompatActivity {

    private final String TAG = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        String[] carros = new String[10];

        for (int i=0 ; i<10 ; i++){
            carros[i] = "Carro "+(i+1);
            Log.i(TAG, carros[i]);
        }

        // Cria uma lista na interface gráfica a partir dos valores fornecidos no vetor carros
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carros);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        //setListAdapter(adapter);


    }


}
