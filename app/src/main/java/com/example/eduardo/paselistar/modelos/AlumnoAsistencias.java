package com.example.eduardo.paselistar.modelos;

import com.google.gson.annotations.SerializedName;

public class AlumnoAsistencias{

	@SerializedName("respuesta")
	private boolean respuesta;

	@SerializedName("cantidad")
	private String cantidad;

	public void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}

	public boolean isRespuesta(){
		return respuesta;
	}

	public void setCantidad(String cantidad){
		this.cantidad = cantidad;
	}

	public String getCantidad(){
		return cantidad;
	}


}