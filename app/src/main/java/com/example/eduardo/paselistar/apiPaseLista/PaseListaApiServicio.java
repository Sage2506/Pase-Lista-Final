package com.example.eduardo.paselistar.apiPaseLista;

import com.example.eduardo.paselistar.modelos.AlumnoAsistencias;
import com.example.eduardo.paselistar.modelos.AlumnoFaltas;
import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;
import com.example.eduardo.paselistar.modelos.ClasesRespuesta;
import com.example.eduardo.paselistar.modelos.FaltasAsistencias;
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
    @GET("cantidadasistenciasalumno.php")
    Call<AlumnoAsistencias> asistencias(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo,
            @Query("materia") String materia,
            @Query("grupo") String grupo,
            @Query("ncontrol") String ncontrol
    );
    @GET("cantidadfaltasalumno.php")
    Call<AlumnoFaltas> faltas(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo,
            @Query("materia") String materia,
            @Query("grupo") String grupo,
            @Query("ncontrol") String ncontrol
    );
    @GET("cantidadasistenciasgrupo.php")
    Call<FaltasAsistencias> asistenciasGrupo(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo,
            @Query("materia") String materia,
            @Query("grupo") String grupo
    );
    @GET("cantidadfaltasgrupo.php")
    Call<FaltasAsistencias> faltasGrupo(
            @Query("usuario") String usuario,
            @Query("usuariovalida") String token,
            @Query("periodoactual") String periodo,
            @Query("materia") String materia,
            @Query("grupo") String grupo
    );

}
