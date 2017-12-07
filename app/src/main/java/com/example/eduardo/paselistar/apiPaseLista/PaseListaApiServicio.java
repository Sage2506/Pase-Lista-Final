package com.example.eduardo.paselistar.apiPaseLista;

import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by eduardo on 4/12/17.
 */

public interface PaseListaApiServicio {
    @GET("obtienealumnos.php")
    Call<AlumnosRespuesta> obtenerListaAlumnos(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo,
            @Query("materia") String materia,
            @Query("grupo") String grupo
    );
    /*@GET("validausuario.php")
    Call<LoginRespuesta> loginUsuario(
            @Query("usuario") String usuario,
            @Query("clave") String clave

    );*/

}
