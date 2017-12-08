package com.example.eduardo.paselistar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

        recyclerView = findViewById(R.id.recyclerView);
        listaAlumnosAdaptador = new ListaAlumnosAdaptador(this);
        recyclerView.setAdapter(listaAlumnosAdaptador);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        listaAlumnosAdaptador.setListener(new ListaAlumnosAdaptador.Listener() {
            @Override
            public void detallesAlumno(AlumnosItem alumno) {
                //TODO: aqui poner lo que va a hacer en long click
            }

            @Override
            public void marcaDesmarcaFalta(AlumnosItem alumnos) {
                //TODO: aqui poner lo que va a hacer en click
            }
        });

        //usuario=920&usuariovalida=49nc8Eznl4dnU&periodoactual=2173&materia=AEB1011&grupo=7A
        String usuario = getIntent().getStringExtra("usuario");
        String token = getIntent().getStringExtra("token");
        String periodoactual= getIntent().getStringExtra("periodoactual");
        String materia = getIntent().getStringExtra("materia");
        String grupo= getIntent().getStringExtra("grupo");


        ApiRetrofit api = new ApiRetrofit();
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
