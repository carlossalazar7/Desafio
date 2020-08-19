package com.login.bean;

public class OfertasBean {
	private int idPromocion;
	private String nombreOferta;
	private float precioNormal;
	private float precioOferta;
	private String fechaInicio;
	private String fechaFinal;
	private int cantidadCupones;
	private String descripcion;
	private String estado;
	private String fechaLimite;
	private String justificacion;
	private String idEmpresa;
	
	
	public OfertasBean() {
		this.idPromocion = 0;
		this.nombreOferta="";
		this.precioNormal= 0;
		this.precioOferta = 0;
		this.fechaInicio = "";
		this.fechaFinal = "";
		this.cantidadCupones = 0;
		this.descripcion = "";
		this.estado = "";
		this.fechaLimite = "";
		this.justificacion = "";
		this.idEmpresa = "";
		
		
		
	}
	
	
	public OfertasBean(int idPromocion, String nombreOferta, float precioNormal, float precioOferta, String fechaInicio,String fechaFinal, int cantidadCupones, String descripcion, String estado, String fechaLimite,String justificacion, String idEmpresa) {
		this.idPromocion = idPromocion;
		this.nombreOferta = nombreOferta;
		this.precioNormal = precioNormal;
		this.precioOferta = precioOferta;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.cantidadCupones = cantidadCupones;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaLimite = fechaLimite;
		this.justificacion = justificacion;
		this.idEmpresa = idEmpresa;
	}


	public int getidPromocion() {
		return idPromocion;
		
	}
	
	public void setidPromocion(int idPromocion) {
		this.idPromocion=idPromocion;
		
	}

	public String getNombreOferta() {
		return nombreOferta;
	}
	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}
	public float getPrecioNormal() {
		return precioNormal;
	}
	public void setPrecioNormal(float precioNormal) {
		this.precioNormal = precioNormal;
	}
	public float getPrecioOferta() {
		return precioOferta;
	}
	public void setPrecioOferta(float precioOferta) {
		this.precioOferta = precioOferta;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public int getCantidadCupones() {
		return cantidadCupones;
	}
	public void setCantidadCupones(int cantidadCupones) {
		this.cantidadCupones = cantidadCupones;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(String fecha) {
		this.fechaLimite = fecha;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	
	

}
