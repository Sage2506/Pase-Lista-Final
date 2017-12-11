package com.example.eduardo.paselistar;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.eduardo.paselistar.apiPaseLista.ApiRetrofit;
import com.example.eduardo.paselistar.modelos.GruposItem;
import com.example.eduardo.paselistar.modelos.LoginRespuesta;

public class LoginActivity extends AppCompatActivity {
    private ApiRetrofit api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = new ApiRetrofit();

        setContentView(R.layout.activity_login);
        final AutoCompleteTextView atUsuario = findViewById(R.id.email);
        final EditText etClave = findViewById(R.id.password);
        Button btn = findViewById(R.id.email_sign_in_button);

        btn.setEnabled(false);
        AddListenerOnTextChange listener = new AddListenerOnTextChange(this, atUsuario,etClave,btn);
        atUsuario.addTextChangedListener(listener);
        etClave.addTextChangedListener(listener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuario(v.getContext(), atUsuario.getText().toString(),etClave.getText().toString());
            }
        });
    }



    private void loginUsuario(final Context context, final String usuario, String clave){
        api.login(usuario,clave,new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                LoginRespuesta login = (LoginRespuesta)respuesta;
                if(login.isRespuesta()){
                    Intent lista = new Intent(context, GruposActivity.class);
                    String token = login.getUsuariovalida();
                    String periodoactual = login.getPeriodoactual();
                    lista.putExtra("usuario",usuario);
                    lista.putExtra("token",token);
                    lista.putExtra("periodoactual",periodoactual);
                    startActivity(lista);
                    finish();
                }
            }

            @Override
            public void fail(Throwable t) {

            }
        });
    }
    public class AddListenerOnTextChange implements TextWatcher{
        private Context context;
        private AutoCompleteTextView actv;
        private EditText et;
        private Button btn;

        public AddListenerOnTextChange(Context context, AutoCompleteTextView ac, EditText et, Button btn){
            this.context=context;
            actv = ac;
            this.et=et;
            this.btn=btn;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(actv.getText().toString().trim().equals("") || et.getText().toString().trim().equals("")){
                btn.setEnabled(false);
                }
                else { btn.setEnabled(true); }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
