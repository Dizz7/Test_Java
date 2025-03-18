package com.dulcehogar.business;

public class Socio {
    private String rut;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String telefono;
    private String domicilio;
    private String comuna;
    private String ciudad;
    private String region;
    private String correo;
    private int numeroSocio;
    private int cantidadAportada;
    private Cuenta cuenta;

    public Socio(String rut, String nombre, String apPaterno, String apMaterno, String telefono, String domicilio, String comuna, String ciudad, String region, String correo, int numeroSocio, int cantidadAportada, Cuenta cuenta) {
    this.rut = rut;
    this.nombre = nombre;
    this.apPaterno = apPaterno;
    this.apMaterno = apMaterno;
    this.telefono = telefono;
    this.domicilio = domicilio;
    this.comuna = comuna;
    this.ciudad = ciudad;
    this.region = region;
    this.correo = correo;
    this.numeroSocio = numeroSocio;
    this.cantidadAportada = cantidadAportada;
    this.cuenta = cuenta;
}
    
    public Socio(){
        }

    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }
    
    
    public int getCantidadAportada() {
        return cantidadAportada;
    }
    
    public void setCantidadAportada(int cantidadAportada) {
        this.cantidadAportada = cantidadAportada;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
       
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta; 
    }
    
}
