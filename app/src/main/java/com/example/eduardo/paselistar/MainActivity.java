package com.example.eduardo.paselistar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.eduardo.paselistar.apiPaseLista.PaseListaApiServicio;
import com.example.eduardo.paselistar.modelos.AlumnosItem;
import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://itculiacan.edu.mx/dadm/apipaselista/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos();
    }
    private void obtenerDatos(){
        PaseListaApiServicio servicio = retrofit.create(PaseListaApiServicio.class);
        final Call<AlumnosRespuesta> listaAlumnosRespuesta = servicio.obtenerListaAlumnos();
        listaAlumnosRespuesta.enqueue(new Callback<AlumnosRespuesta>() {
            @Override
            public void onResponse(Call<AlumnosRespuesta> call, Response<AlumnosRespuesta> response) {
                if(response.isSuccessful()){
                    AlumnosRespuesta listaAlumnos = response.body();
                    ArrayList<AlumnosItem> alumnos = listaAlumnos.getAlumnos();
                    for (int i = 0; i<alumnos.size(); i++){
                        AlumnosItem a = alumnos.get(i);
                        Log.i(TAG, "alumno "+a.getNombre());
                    }
                }else {
                    Log.e(TAG, " onResponse "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<AlumnosRespuesta> call, Throwable t) {
                Log.e(TAG, " onFaailure " +t.getMessage());
            }
        });
    }
}
