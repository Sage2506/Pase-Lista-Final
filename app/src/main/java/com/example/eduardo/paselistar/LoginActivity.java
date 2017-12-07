package com.example.eduardo.paselistar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.eduardo.paselistar.apiPaseLista.ApiRetrofit;
import com.example.eduardo.paselistar.modelos.LoginRespuesta;

public class LoginActivity extends AppCompatActivity {
    private ApiRetrofit api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final AutoCompleteTextView atUsuario = findViewById(R.id.email);
        final EditText etClave = findViewById(R.id.password);
        Button btn = findViewById(R.id.email_sign_in_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuario(v.getContext(), atUsuario.getText().toString(),etClave.getText().toString());
            }
        });
        api = new ApiRetrofit();

    }
    private void loginUsuario(final Context context, String usuario, String clave){
        api.login(new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                LoginRespuesta login = (LoginRespuesta)respuesta;
                if(login.isRespuesta()){
                    Intent lista = new Intent(context, MainActivity.class);
                    startActivity(lista);
                }
            }

            @Override
            public void fail(Throwable t) {

            }
        });
    }
}
