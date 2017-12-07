package com.example.eduardo.paselistar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.eduardo.paselistar.Adaptadores.ListaGruposAdaptador;
import com.example.eduardo.paselistar.apiPaseLista.ApiRetrofit;
import com.example.eduardo.paselistar.modelos.GruposItem;

import java.util.ArrayList;

public class GruposActivity extends AppCompatActivity {
    private static final String TAG = "GruposActivity";
    private ApiRetrofit api;
    private RecyclerView recyclerView;
    private ListaGruposAdaptador listaGruposAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);
        api = new ApiRetrofit();
        recyclerView = findViewById(R.id.rvGrupos);
        listaGruposAdaptador = new ListaGruposAdaptador(this);
        recyclerView.setAdapter(listaGruposAdaptador);

        final String usuario = getIntent().getStringExtra("usuario");
        final String token = getIntent().getStringExtra("token");
        final String periodo = getIntent().getStringExtra("periodoactual");

        listaGruposAdaptador.setListener(new ListaGruposAdaptador.Listener() {
            @Override
            public void verDetalles(GruposItem grupo) {
                Intent detallesGrupo = new Intent(getApplicationContext(),DetallesGrupoActivity.class);
                detallesGrupo.putExtra("materia",grupo.getMateria());
                detallesGrupo.putExtra("clavemateria",grupo.getClavemateria());
                detallesGrupo.putExtra("grupo",grupo.getGrupo());
                detallesGrupo.putExtra("hLunes",grupo.getHoralunes());
                detallesGrupo.putExtra("hMartes",grupo.getHoramartes());
                detallesGrupo.putExtra("hMiercoles",grupo.getHoramiercoles());
                detallesGrupo.putExtra("hJueves",grupo.getHorajueves());
                detallesGrupo.putExtra("hViernes",grupo.getHoraviernes());
                startActivity(detallesGrupo);
            }

            @Override
            public void abreLista(String materia, String grupo) {
                Intent listaAlumnos = new Intent(getApplicationContext(), MainActivity.class);
                listaAlumnos.putExtra("usuario",usuario);
                listaAlumnos.putExtra("token",token);
                listaAlumnos.putExtra("periodoactual",periodo);
                listaAlumnos.putExtra("materia",materia);
                listaAlumnos.putExtra("grupo", grupo);
                startActivity(listaAlumnos);
            }
        });
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);



        api.obtenerListaGrupos(usuario,token,periodo,new ApiRetrofit.ServiceCallBack() {
            @Override
            public void respuestaRecibida(Object respuesta) {
                listaGruposAdaptador.agregarListaGrupos((ArrayList<GruposItem>)respuesta);
            }

            @Override
            public void fail(Throwable t) {
                Log.e(TAG, " onFailure " +t.getMessage());
            }
        });
    }
}
