package com.example.eduardo.paselistar.modelos;

import com.google.gson.annotations.SerializedName;

public class RespuestaSimple{

	@SerializedName("respuesta")
	private boolean respuesta;

	public void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}

	public boolean isRespuesta(){
		return respuesta;
	}
}