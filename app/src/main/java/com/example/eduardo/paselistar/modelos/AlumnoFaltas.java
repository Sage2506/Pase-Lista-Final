package com.example.eduardo.paselistar.modelos;

import com.google.gson.annotations.SerializedName;

public class AlumnoFaltas{

	@SerializedName("respuesta")
	private boolean respuesta;

	@SerializedName("cantidad")
	private String cantidad;

	public boolean isRespuesta() {
		return respuesta;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}