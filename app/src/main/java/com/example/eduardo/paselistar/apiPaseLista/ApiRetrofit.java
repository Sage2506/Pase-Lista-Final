package com.example.eduardo.paselistar.apiPaseLista;

import android.util.Log;

import com.example.eduardo.paselistar.modelos.AlumnosItem;
import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;
import com.example.eduardo.paselistar.modelos.ClasesRespuesta;
import com.example.eduardo.paselistar.modelos.GruposItem;
import com.example.eduardo.paselistar.modelos.LoginRespuesta;

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

    public void obtenerListaAlumnos(String usuario, String token, String periodo, String materia, String grupo, final ServiceCallBack serviceCallBack) {

        Call<AlumnosRespuesta> listaAlumnosRespuesta = servicio.obtenerListaAlumnos(
                usuario,
                token,
                periodo,
                materia,
                grupo);

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

    public void login(String usuario, String clave, final ServiceCallBack serviceCallBack){
        Call<LoginRespuesta> loginRespuestaCall = servicio.loginUsuario(
                usuario,
                clave
        );

        loginRespuestaCall.enqueue(new Callback<LoginRespuesta>() {
            @Override
            public void onResponse(Call<LoginRespuesta> call, Response<LoginRespuesta> response) {
                if(response.isSuccessful()){
                    LoginRespuesta validacion = response.body();
                    serviceCallBack.respuestaRecibida(validacion);
                } else { Log.e(TAG, " onResponse " + response.errorBody());}
            }

            @Override
            public void onFailure(Call<LoginRespuesta> call, Throwable t) {
                    serviceCallBack.fail(t);
            }
        });
    }

    public void obtenerListaGrupos(String usuario, String token, String periodo, final ServiceCallBack serviceCallBack){

        Call<ClasesRespuesta> clasesRespuestaCall = servicio.obtenerlistaGrupos(
                "920",
                "49nc8Eznl4dnU",
                "2173"
        );

        clasesRespuestaCall.enqueue(new Callback<ClasesRespuesta>() {
            @Override
            public void onResponse(Call<ClasesRespuesta> call, Response<ClasesRespuesta> response) {
                if (response.isSuccessful()){
                    ClasesRespuesta listaClases = response.body();
                    ArrayList<GruposItem> clases = new ArrayList<>();
                    clases = listaClases.getGrupos();
                    serviceCallBack.respuestaRecibida(clases);
                } else { Log.e(TAG," onResponse " + response.errorBody()); }
            }

            @Override
            public void onFailure(Call<ClasesRespuesta> call, Throwable t) { serviceCallBack.fail(t); }
        });
    }


    public interface ServiceCallBack {
        void respuestaRecibida(Object respuesta);
        void fail(Throwable t);
    }
}
