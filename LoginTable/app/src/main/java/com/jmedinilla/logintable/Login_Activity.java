package com.jmedinilla.logintable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.jmedinilla.logintable.controllers.ILoginMvc;
import com.jmedinilla.logintable.controllers.Login_Activity_Controller;

/**
 * Main class that validate the login credentials
 *
 * @author JMedinilla
 * @version 1.0
 * @see ILoginMvc
 * @see Login_Activity_Controller
 */
public class Login_Activity extends AppCompatActivity {

    private ILoginMvc loginMvc;

    private EditText edtUser;
    private EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginMvc = new Login_Activity_Controller();

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPass = (EditText)findViewById(R.id.edtPass);
        Button btnOk = (Button) findViewById(R.id.btnOk);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        if (btnOk != null) {
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = edtUser.getText().toString();
                    String pass = edtPass.getText().toString();
                    if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
                        Toast.makeText(Login_Activity.this, getResources().getString(R.string.empty_data), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int result = loginMvc.validateCredentials(user, pass);
                        switch (result) {
                            case Login_Activity_Controller.PASSWORD_DIGIT:
                                Toast.makeText(Login_Activity.this, getResources().getString(R.string.password_digit), Toast.LENGTH_SHORT).show();
                                break;
                            case Login_Activity_Controller.PASSWORD_CASE:
                                Toast.makeText(Login_Activity.this, getResources().getString(R.string.password_case), Toast.LENGTH_SHORT).show();
                                break;
                            case Login_Activity_Controller.PASSWORD_LENGTH:
                                Toast.makeText(Login_Activity.this, getResources().getString(R.string.password_length), Toast.LENGTH_SHORT).show();
                                break;
                            case Login_Activity_Controller.OK:
                                //New Activity after the login
                                break;
                        }
                    }
                }
            });
        }

        //The cancel button only calls the method to reset the EditTexts
        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetValues();
                }
            });
        }
    }

    /**
     * Method that deletes the text on the EditTexts
     */
    private void resetValues() {
        edtPass.setText("");
        edtUser.setText("");
    }
}
