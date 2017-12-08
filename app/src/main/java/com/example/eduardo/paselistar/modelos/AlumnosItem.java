package com.example.eduardo.paselistar.modelos;

import com.google.gson.annotations.SerializedName;

public class AlumnosItem{

	@SerializedName("0")
	private String jsonMember0;

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	@SerializedName("3")
	private String jsonMember3;

	@SerializedName("ncontrol")
	private String ncontrol;

	@SerializedName("apellidomaterno")
	private String apellidomaterno;

	@SerializedName("apellidopaterno")
	private String apellidopaterno;

	@SerializedName("nombre")
	private String nombre;

	private String asistencia;

	public String getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}

	public void setJsonMember0(String jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public String getJsonMember0(){
		return jsonMember0;
	}

	public void setJsonMember1(String jsonMember1){
		this.jsonMember1 = jsonMember1;
	}

	public String getJsonMember1(){
		return jsonMember1;
	}

	public void setJsonMember2(String jsonMember2){
		this.jsonMember2 = jsonMember2;
	}

	public String getJsonMember2(){
		return jsonMember2;
	}

	public void setJsonMember3(String jsonMember3){
		this.jsonMember3 = jsonMember3;
	}

	public String getJsonMember3(){
		return jsonMember3;
	}

	public void setNcontrol(String ncontrol){
		this.ncontrol = ncontrol;
	}

	public String getNcontrol(){
		return ncontrol;
	}

	public void setApellidomaterno(String apellidomaterno){
		this.apellidomaterno = apellidomaterno;
	}

	public String getApellidomaterno(){
		return apellidomaterno;
	}

	public void setApellidopaterno(String apellidopaterno){
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidopaterno(){
		return apellidopaterno;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	@Override
 	public String toString(){
		return 
			"AlumnosItem{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",1 = '" + jsonMember1 + '\'' + 
			",2 = '" + jsonMember2 + '\'' + 
			",3 = '" + jsonMember3 + '\'' + 
			",ncontrol = '" + ncontrol + '\'' + 
			",apellidomaterno = '" + apellidomaterno + '\'' + 
			",apellidopaterno = '" + apellidopaterno + '\'' + 
			",nombre = '" + nombre + '\'' + 
			"}";
		}
}