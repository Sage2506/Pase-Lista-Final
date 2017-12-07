package com.example.eduardo.paselistar.modelos;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ClasesRespuesta{

	@SerializedName("grupos")
	private ArrayList<GruposItem> grupos;

	@SerializedName("respuesta")
	private boolean respuesta;

	public void setGrupos(ArrayList<GruposItem> grupos){
		this.grupos = grupos;
	}

	public ArrayList<GruposItem> getGrupos(){
		return grupos;
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
			"ClasesRespuesta{" + 
			"grupos = '" + grupos + '\'' + 
			",respuesta = '" + respuesta + '\'' + 
			"}";
		}
}