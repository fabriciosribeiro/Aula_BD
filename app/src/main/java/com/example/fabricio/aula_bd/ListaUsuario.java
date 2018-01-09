package com.example.fabricio.aula_bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class ListaUsuario extends AppCompatActivity {

    private final String TAG = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        /*
        // ArrayAdapter
        String[] carros = new String[10];

        for (int i=0 ; i<10 ; i++){
            carros[i] = "Carro "+(i+1);
            Log.i(TAG, carros[i]);
        }

        // Cria uma lista na interface gráfica a partir dos valores fornecidos no vetor carros
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carros);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);*/

        // SimpleAdapter
        ArrayList<HashMap<String,String>> carros = new ArrayList<HashMap<String, String>>();

        for (int i=0 ; i<10 ; i++){
            HashMap<String,String> carro = new HashMap<String,String>();
            carro.put("carro", "Carro "+(i+1));
            carro.put("marca", "Marca "+(i+1));

            carros.add(carro);
        }

        String[] de = new String[]{"carro", "marca"};
        int layoutNativo = android.R.layout.two_line_list_item;
        int[] para = new int[]{android.R.id.text1,android.R.id.text2};

        // Cria uma lista na interface gráfica a partir dos valores fornecidos no vetor carros
        SimpleAdapter adapter =
                new SimpleAdapter(this, carros, layoutNativo, de, para);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);



    }


}
