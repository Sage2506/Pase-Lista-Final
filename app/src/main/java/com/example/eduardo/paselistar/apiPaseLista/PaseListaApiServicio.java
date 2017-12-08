package com.example.eduardo.paselistar.apiPaseLista;

import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;
import com.example.eduardo.paselistar.modelos.ClasesRespuesta;
import com.example.eduardo.paselistar.modelos.LoginRespuesta;
import com.example.eduardo.paselistar.modelos.RespuestaSimple;

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

    @GET("validausuario.php")
    Call<LoginRespuesta> loginUsuario(
            @Query("usuario") String usuario,
            @Query("clave") String clave

    );

    @GET("obtienegrupos.php")
    Call<ClasesRespuesta> obtenerlistaGrupos(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo
    );
    @GET("asignaincidencia.php")
    Call<RespuestaSimple> asignaIncidencia(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo,
            @Query("materia") String materia,
            @Query("grupo") String grupo,
            @Query("ncontrol") String ncontrol,
            @Query("incidencia") String asigna
    );

}
