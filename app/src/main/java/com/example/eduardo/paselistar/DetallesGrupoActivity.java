package com.example.eduardo.paselistar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetallesGrupoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_grupo);
        String materia = getIntent().getStringExtra("materia");
        String grupo = getIntent().getStringExtra("grupo");
        String clavemateria = getIntent().getStringExtra("clavemateria");
        String hLunes= getIntent().getStringExtra("hLunes");
        String hMartes= getIntent().getStringExtra("hMartes");
        String hMiercoles = getIntent().getStringExtra("hMiercoles");
        String hJueves = getIntent().getStringExtra("hJueves");
        String hViernes = getIntent().getStringExtra("hViernes");

        TextView tvMateria = findViewById(R.id.tvMateria);
        TextView tvClaveMateria = findViewById(R.id.tvClaveMateria);
        TextView tvGrupo = findViewById(R.id.tvGrupo);
        TextView tvLunes = findViewById(R.id.tvHoraL);
        TextView tvMartes =findViewById(R.id.tvHoraMa);
        TextView tvMiercoles =findViewById(R.id.tvHoraMi);
        TextView tvJueves =findViewById(R.id.tvHoraJ);
        TextView tvViernes =findViewById(R.id.tvHoraV);

        tvMateria.setText(materia);
        tvClaveMateria.setText(clavemateria);
        tvGrupo.setText(grupo);
        tvLunes.setText(hLunes);
        tvMartes.setText(hMartes);
        tvMiercoles.setText(hMiercoles);
        tvJueves.setText(hJueves);
        tvViernes.setText(hJueves);
    }
}
