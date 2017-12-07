package com.example.eduardo.paselistar.modelos;

import com.google.gson.annotations.SerializedName;

public class LoginRespuesta{

	@SerializedName("usuariovalida")
	private String usuariovalida;

	@SerializedName("periodoactual")
	private String periodoactual;

	@SerializedName("respuesta")
	private boolean respuesta;

	public void setUsuariovalida(String usuariovalida){
		this.usuariovalida = usuariovalida;
	}

	public String getUsuariovalida(){
		return usuariovalida;
	}

	public void setPeriodoactual(String periodoactual){
		this.periodoactual = periodoactual;
	}

	public String getPeriodoactual(){
		return periodoactual;
	}

	public void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}

	public boolean isRespuesta(){
		return respuesta;
	}

	@Override
 	public String toString(){
		return 
			"LoginRespuesta{" + 
			"usuariovalida = '" + usuariovalida + '\'' + 
			",periodoactual = '" + periodoactual + '\'' + 
			",respuesta = '" + respuesta + '\'' + 
			"}";
		}
}