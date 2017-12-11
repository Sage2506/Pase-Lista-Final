package com.example.eduardo.paselistar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.eduardo.paselistar.Adaptadores.ListaAlumnosAdaptador;
import com.example.eduardo.paselistar.apiPaseLista.ApiRetrofit;
import com.example.eduardo.paselistar.modelos.AlumnosItem;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ListaAlumnosAdaptador listaAlumnosAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_accept);

        final String usuario = getIntent().getStringExtra("usuario");
        final String token = getIntent().getStringExtra("token");
        final String periodoactual= getIntent().getStringExtra("periodoactual");
        final String materia = getIntent().getStringExtra("materia");
        final String grupo= getIntent().getStringExtra("grupo");

        recyclerView = findViewById(R.id.recyclerView);
        listaAlumnosAdaptador = new ListaAlumnosAdaptador(this);
        recyclerView.setAdapter(listaAlumnosAdaptador);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        listaAlumnosAdaptador.setListener(new ListaAlumnosAdaptador.Listener() {
            @Override
            public void detallesAlumno(AlumnosItem alumno) {
                Intent details = new Intent(getApplicationContext(), AlumnsDetailsActivity.class);
                details.putExtra("Nombre", alumno.fullName());
                details.putExtra("ncontrol",alumno.getNcontrol());
                details.putExtra("token",token);
                details.putExtra("periodoactual",periodoactual);
                details.putExtra("materia",materia);
                details.putExtra("grupo",grupo);
                details.putExtra("usuario",usuario);
                startActivity(details);
            }

            @Override
            public void marcaDesmarcaFalta(AlumnosItem alumnos,View view) {
                if(alumnos.getAsistencia() == null || alumnos.getAsistencia()=="1"){
                    alumnos.setAsistencia("2");
                }else if (alumnos.getAsistencia()=="2"){
                    alumnos.setAsistencia("1");
                }
                listaAlumnosAdaptador.notifyDataSetChanged();
            }
        });




        final ApiRetrofit api = new ApiRetrofit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaAlumnosAdaptador.getDataset();
                for (AlumnosItem a:listaAlumnosAdaptador.getDataset()) {
                    if(a.getAsistencia()==null){a.setAsistencia("1");}
                    api.ponerFaltaAsistencia(usuario,token, periodoactual,materia,grupo,a.getNcontrol(),a.getAsistencia());
                }
                finish();
            }
        });

        api.obtenerListaAlumnos(usuario, token, periodoactual, materia, grupo ,new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                listaAlumnosAdaptador.agregarListaAlumnos((ArrayList<AlumnosItem>)respuesta);
            }
            @Override
            public void fail(Throwable t) {
                Log.e(TAG, " onFaailure " +t.getMessage());
            }
        });
    }

}
