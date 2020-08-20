package com.login.bean;

public class RubroBean {
	private int idRubro;
	private String nombreRubro;

	public RubroBean() {
		this.idRubro = 0;
		this.nombreRubro = "";
	}

	public RubroBean(int idRubro, String nombreRubro) {
		this.idRubro = idRubro;
		this.nombreRubro = nombreRubro;
	}

	public int getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(int idRubro) {
		this.idRubro = idRubro;
	}

	public String getNombreRubro() {
		return nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}
}
