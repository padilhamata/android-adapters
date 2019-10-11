package com.example.atividadesobreadapters_simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tela extends AppCompatActivity {

    List<HashMap<String,String>> lista = new ArrayList<>();
    protected static final String TAG = "fasam";
    EditText txtNome;
    EditText txtSobreNome;
    EditText txtEmail;
    EditText txtTelefone;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela);
    }

    public void adicionar(View view) {

        txtNome = findViewById(R.id.txtNome);
        txtSobreNome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone= findViewById(R.id.txtTelefone);

        String nome, sobrenome, email, telefone;

        nome = txtNome.getText().toString();
        sobrenome = txtSobreNome.getText().toString();
        email = txtEmail.getText().toString();
        telefone = txtTelefone.getText().toString();

        String dados = String.format("Os dados são %s %s %s %s", nome,sobrenome,email,telefone);

        Toast.makeText(getApplicationContext(),dados,
                Toast.LENGTH_LONG).show();

        HashMap<String,String> map = new HashMap<>();
        map.put("nome",nome);
        map.put("sobrenome",sobrenome);
        map.put("email",email);
        map.put("telefone",telefone);


        lista.add(map);

        Log.i(TAG,lista.toString());
        String[] de = {"nome","sobrenome","email","telefone"};

        int[] para = {R.id.txtNome,R.id.txtSobrenome,R.id.txtEmail,R.id.txtTelefone};


        //Adicionar itens na listView - Usando SimpleAdapter

        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                lista,
                R.layout.activity_pessoa,
                de,
                para


        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Log.i(TAG,lista.toString());
    }
}
