package com.example.eduardo.paselistar.modelos;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class AlumnosRespuesta{

	@SerializedName("alumnos")
	private ArrayList<AlumnosItem> alumnos;

	@SerializedName("respuesta")
	private boolean respuesta;

	public void setAlumnos(ArrayList<AlumnosItem> alumnos){
		this.alumnos = alumnos;
	}

	public ArrayList<AlumnosItem> getAlumnos(){
		return alumnos;
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
			"AlumnosRespuesta{" + 
			"alumnos = '" + alumnos + '\'' + 
			",respuesta = '" + respuesta + '\'' + 
			"}";
		}
}