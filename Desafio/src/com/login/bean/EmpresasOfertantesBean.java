package com.login.bean;

public class EmpresasOfertantesBean {

	private String idEmpresa;
	private String nombreEmpresa;
	private float comision;
	private String direcciion;
	private String Nombrecontacto;
	private String telefono;
	private String correo;
	private String password;

	public EmpresasOfertantesBean() {
		this.idEmpresa = "";
		this.nombreEmpresa = "";
		this.comision = 0;
		this.direcciion = "";
		this.Nombrecontacto = "";
		this.telefono = "";
		this.correo = "";
		this.password = "";
	}

	public EmpresasOfertantesBean(String idEmpresa, String nombreEmpresa, float comision, String direcciion,
			String Nombrecontacto, String telefono, String correo, String password) {
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.comision = comision;
		this.direcciion = direcciion;
		this.Nombrecontacto = Nombrecontacto;
		this.telefono = telefono;
		this.correo = correo;
		this.password = password;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public String getDirecciion() {
		return direcciion;
	}

	public void setDirecciion(String direcciion) {
		this.direcciion = direcciion;
	}

	public String getNombrecontacto() {
		return Nombrecontacto;
	}

	public void setNombrecontacto(String nombrecontacto) {
		Nombrecontacto = nombrecontacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(int idRubro) {
		this.idRubro = idRubro;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private int idRubro;

}
