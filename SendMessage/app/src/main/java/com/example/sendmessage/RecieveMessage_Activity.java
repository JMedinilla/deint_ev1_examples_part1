package com.example.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Clase que recive un mensaje de otra Actividad
 * @see android.app.Activity
 * @author Javier Medinilla
 * @version 1.0
 */
//TODO Segunda Actividad
public class RecieveMessage_Activity extends AppCompatActivity {

    //Controles
    private TextView txtMessage_Recieved;
    //Objetos
    private static final String TAG = "com.example.usuario";

    /**
     * Metodo que crea la actividad
     * @param savedInstanceState @see {@link Bundle}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);

        Log.d(TAG, "onCreate: La actividad se ha creado");
        sendToast("onCreate R");

        initialize();

        String message;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            if (extras == null) {
                message = getResources().getString(R.string.nullMessage);
            }
            else {
                message = extras.getString("messageSent");
                if (message == null) {
                    message = getResources().getString(R.string.emptyMessage);
                }
                else if (message.isEmpty()) {
                    message = getResources().getString(R.string.emptyMessage);
                }
            }
        }
        else {
            message = (String)savedInstanceState.getSerializable("messageSent");
        }
        txtMessage_Recieved.setText(message);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: La actividad se ha iniciado");
        sendToast("onStart R");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: La actividad es visible");
        sendToast("onResume R");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: La actividad no es visible");
        sendToast("onPause R");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: La actividad ha finalizado");
        sendToast("onStop R");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: La actividad se ha destruido");
        sendToast("onDestroy R");
    }

    /**
     * Metodo que inicializa los componentes y sus propiedades
     * @see TextView
     */
    private void initialize() {
        txtMessage_Recieved = (TextView)findViewById(R.id.txtMessage_Recieved);
    }

    private void sendToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
