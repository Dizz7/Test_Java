package com.dulcehogar.business;

public class Cuenta {
    private int numeroSocio;
    private int valorCuota;
    private int cantidadAportada;
    private Socio socio;

    public Cuenta(int numeroSocio, int valorCuota, int cantidadAportada, Socio socio) {
        this.socio = socio;
        this.numeroSocio = numeroSocio;
        this.valorCuota = valorCuota;
        this.cantidadAportada = cantidadAportada;
    }

    public Cuenta(){
    
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }

    public void setCantidadAportada(int cantidadAportada) {
        this.cantidadAportada = cantidadAportada;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public int getCantidadAportada() {
        return cantidadAportada;
    } 
    
    public Socio getSocio() {
        return socio;
    }
    
}

