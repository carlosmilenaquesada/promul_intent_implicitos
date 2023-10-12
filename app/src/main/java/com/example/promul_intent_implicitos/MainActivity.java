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

    /*
     *Los intent implícitos no son ejecutados por un programa concreto, sino que muestran una
     * lista de programas disponibles que pueden ejecutar la acción del intent (estos programas deben
     * estar instalados en nuestro dispositivo).
     *
     * Por ejemplo, abrir una dirección web puede hacerlos chrome, opera, firefox, etc. así que si
     * configuramos el intent como Intent.ACTION_VIEW, al ejecutarlo, podremos elegir cual programa lo abrirá.
     *
     * Existen diversos tipos de intent de esta naturaleza, por ejemplo Intent.ACTION_VIEW, es para direcciones
     * de páginas web, Intent.ACTION_SEND para mandar correos electrónicos, para mandar un texto a una aplicacion se usa
     * ShareCompat.IntentBuilder, etc.
     * */
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
                abrirNavegadorWeb();
            }
        });


        botonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirMapa();
            }
        });

        botonCopiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copiarTexto();
            }
        });


    }

    /*
    * Intent para abrir una dirección web proporcionada por el usuario. Tendremos que tomar la
    * dirección de un textfield, comprobar que es una web válida, configurar el intent y finalmente
    * lanzarlo
    * */
    private void abrirNavegadorWeb() {
        String url = String.valueOf(textoWeb.getText());
        String regex = "^(https?|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(:(\\d{1,5}))?(/\\S*)?$";
        if (url.matches(regex)) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } else {
            textoWeb.setError("La dirección introducida no es válida");
        }
    }

    /*
     * Intent para abrir una localización en mapa dada por el usuario. Tendremos que tomar la
     * localizacion de un textfield, configurar el intent y finalmente lanzarlo.
     *
     * Es igual que en el caso de la dirección web, pero con un añadido en el intent.setData();
     * */
    private void abrirMapa() {
        String localizacion = String.valueOf(textoMap.getText());
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + localizacion));
        startActivity(intent);
    }

    /*
    * Intent para llevar un texto a una aplicación, o al portapapeles.
    * */

    private void copiarTexto(){


    }

}































