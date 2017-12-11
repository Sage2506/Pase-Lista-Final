package com.example.eduardo.paselistar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eduardo.paselistar.apiPaseLista.ApiRetrofit;
import com.example.eduardo.paselistar.modelos.FaltasAsistencias;

public class DetallesGrupoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_grupo);
        Intent data = getIntent();
        String materia = data.getStringExtra("materia");
        String grupo = data.getStringExtra("grupo");
        String clavemateria = data.getStringExtra("clavemateria");
        String hLunes= data.getStringExtra("hLunes");
        String hMartes= data.getStringExtra("hMartes");
        String hMiercoles = data.getStringExtra("hMiercoles");
        String hJueves = data.getStringExtra("hJueves");
        String hViernes = data.getStringExtra("hViernes");
        String usuario = data.getStringExtra("usuario");
        String token = data.getStringExtra("token");
        String periodo = data.getStringExtra("periodoactual");

        TextView tvMateria = findViewById(R.id.tvMateria);
        TextView tvClaveMateria = findViewById(R.id.tvClaveMateria);
        TextView tvGrupo = findViewById(R.id.tvGrupo);
        TextView tvLunes = findViewById(R.id.tvHoraL);
        TextView tvMartes =findViewById(R.id.tvHoraMa);
        TextView tvMiercoles =findViewById(R.id.tvHoraMi);
        TextView tvJueves =findViewById(R.id.tvHoraJ);
        TextView tvViernes =findViewById(R.id.tvHoraV);
        final TextView tvAsistencias = findViewById(R.id.tv_asistencias);
        final TextView tvFaltas=findViewById(R.id.tv_faltas);

        tvMateria.setText(materia);
        tvClaveMateria.setText(clavemateria);
        tvGrupo.setText(grupo);
        tvLunes.setText(hLunes);
        tvMartes.setText(hMartes);
        tvMiercoles.setText(hMiercoles);
        tvJueves.setText(hJueves);
        tvViernes.setText(hViernes);

        ApiRetrofit api = new ApiRetrofit();

        api.getAsistenciaFalta(usuario, token, periodo, clavemateria, grupo, 1, new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                tvAsistencias.setText("Asistencias: "+((FaltasAsistencias)respuesta).getCantidad());
            }

            @Override
            public void fail(Throwable t) {

            }
        });
        api.getAsistenciaFalta(usuario, token, periodo, clavemateria, grupo, 2, new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                tvFaltas.setText("Faltas: "+((FaltasAsistencias)respuesta).getCantidad());
            }

            @Override
            public void fail(Throwable t) {

            }
        });
    }
}
