package com.example.eduardo.paselistar.apiPaseLista;

import com.example.eduardo.paselistar.modelos.AlumnosRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eduardo on 4/12/17.
 */

public interface PaseListaApiServicio {
    @GET("obtienealumnos.php?usuario=920&usuariovalida=49nc8Eznl4dnU&periodoactual=2173&materia=AEB1011&grupo=7A")
    Call<AlumnosRespuesta> obtenerListaAlumnos();
}
