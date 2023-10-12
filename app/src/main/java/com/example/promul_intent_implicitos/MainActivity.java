package com.example.promul_intent_implicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textoWeb;
    TextView textoMap;
    TextView textoCopiar;

    Button botonWeb;
    Button botonMap;
    Button botonCopiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoWeb = (TextView) findViewById(R.id.textoWeb);
        textoMap = (TextView) findViewById(R.id.textoMap);
        textoCopiar = (TextView) findViewById(R.id.textoCopiar);

        botonWeb = (Button) findViewById(R.id.botonWeb);
        botonMap = (Button) findViewById(R.id.botonMap);
        botonCopiar = (Button) findViewById(R.id.botonCopiar);

        botonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNavegador();
            }
        });


        botonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        botonCopiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private void abrirNavegador() {
        String url = textoWeb.getText().toString();

        if(url.matches("^(https?|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(:(\\d{1,5}))?(/\\S*)?$")){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }else {
            textoWeb.setError("La dirección introducida no es válida");
        }

    }
}































