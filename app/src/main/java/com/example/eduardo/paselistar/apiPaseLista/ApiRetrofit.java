package com.example.eduardo.paselistar.apiPaseLista;

import android.app.Application;
import android.util.Log;

import com.example.eduardo.paselistar.modelos.AlumnosItem;
import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * Created by germa on 06/12/2017.
 */

public class ApiRetrofit {
    final static String TAG = "RetrofitClass";
    public Retrofit retrofit;
    final PaseListaApiServicio servicio;
    public ArrayList<AlumnosItem> alumnos;
    public ApiRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://itculiacan.edu.mx/dadm/apipaselista/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //   servicio = retrofit.create(PaseListaApiServicio.class);
        alumnos = new ArrayList<>();
        servicio = retrofit.create(PaseListaApiServicio.class);
    }

    public void obtenerListaAlumnos(final ServiceCallBack serviceCallBack) {
        //PaseListaApiServicio servicio = retrofit.create(PaseListaApiServicio.class);
        //?usuario=920&usuariovalida=&periodoactual=&materia=&grupo=7A

        Call<AlumnosRespuesta> listaAlumnosRespuesta = servicio.obtenerListaAlumnos(
                "920",
                "49nc8Eznl4dnU",
                "2173",
                "AEB1011",
                "7A");

        listaAlumnosRespuesta.enqueue(new Callback<AlumnosRespuesta>() {
            @Override
            public void onResponse(Call<AlumnosRespuesta> call, Response<AlumnosRespuesta> response) {
                if (response.isSuccessful()) {
                    AlumnosRespuesta listaAlumnos = response.body();
                    alumnos = listaAlumnos.getAlumnos();
                    serviceCallBack.respuestaRecibida(alumnos);

                } else { Log.e(TAG, " onResponse " + response.errorBody()); }
            }
            @Override
            public void onFailure(Call<AlumnosRespuesta> call, Throwable t) { serviceCallBack.fail(t); }
        });
    }

    /*public void login(final ServiceCallBack serviceCallBack){

    }*/

    public interface ServiceCallBack {
        void respuestaRecibida(Object respuesta);
        void fail(Throwable t);
    }
}
