package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Clase que envia un mensaje a otra actividad
 * @see android.app.Activity
 * @author Javier Medinilla
 * @version 1.0
 */
//TODO Primera actividad
public class SendMessage_Activity extends AppCompatActivity {


    //Controles
    private EditText edtMessage;
    //Objetos
    private Intent intent;
    private static final String TAG = "com.example.usuario";

    /**
     * Metodo que crea la actividad
     * @param savedInstanceState @see {@link Bundle}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Log.d(TAG, "onCreate: La actividad se ha creado");
        sendToast("onCreate S");

        initialize();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: La actividad se ha iniciado");
        sendToast("onStart S");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: La actividad es visible");
        sendToast("onResume S");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: La actividad no es visible");
        sendToast("onPause S");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: La actividad ha finalizado");
        sendToast("onStop S");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: La actividad se ha destruido");
        sendToast("onDestroy S");
    }

    /**
     * Metodo que inicializa los componentes y sus propiedades
     * @see EditText
     * @see Button
     */
    private void initialize() {
        edtMessage = (EditText)findViewById(R.id.edtMessage);
    }

    public void getOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnSendMessage:
                Bundle bundle = new Bundle();
                bundle.putString("messageSent", edtMessage.getText().toString());

                /**
                 * Creacion de un Intent para llamar a otra Actividad
                 * @see Intent
                 */
                intent = new Intent(SendMessage_Activity.this, RecieveMessage_Activity.class);
                intent.putExtras(bundle);
                //intent.putExtra("messageSent", edtMessage.getText().toString());
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void sendToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
