package com.example.eduardo.paselistar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.eduardo.paselistar.apiPaseLista.ApiRetrofit;
import com.example.eduardo.paselistar.modelos.AlumnoAsistencias;
import com.example.eduardo.paselistar.modelos.AlumnoFaltas;

import org.w3c.dom.Text;

public class AlumnsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumns_details);
        Intent data = getIntent();
        String usuario = data.getStringExtra("usuario");
        String token = data.getStringExtra("token");
        String periodoactual = data.getStringExtra("periodoactual");
        String materia = data.getStringExtra("materia");
        String grupo = data.getStringExtra("grupo");
        String ncontrol = data.getStringExtra("ncontrol");
        String FullName = data.getStringExtra("Nombre");

        ApiRetrofit api = new ApiRetrofit();

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvNControl = findViewById(R.id.tv_ncontrol);
        final TextView tvAsistencias = findViewById(R.id.tv_asistencias);
        final TextView tvFaltas = findViewById(R.id.tv_faltas);
        ImageView pic = findViewById(R.id.iv_profile_pic);

        tvName.setText(FullName);
        tvNControl.setText("Numero de control: "+ncontrol);

        api.getAsistencias(usuario, token, periodoactual, materia, grupo, ncontrol, new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                tvAsistencias.setText("Asistencias: "+((AlumnoAsistencias)respuesta).getCantidad());
            }

            @Override
            public void fail(Throwable t) {

            }
        });
        api.getFaltas(usuario, token, periodoactual, materia, grupo, ncontrol, new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                tvFaltas.setText("Faltas: "+((AlumnoFaltas)respuesta).getCantidad());
            }

            @Override
            public void fail(Throwable t) {

            }
        });
        Glide.with(this)
                .load("http://189.202.197.43/fotos/"+ncontrol+".jpg")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pic);


    }

}
