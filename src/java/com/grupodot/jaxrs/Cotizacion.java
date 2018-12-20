/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodot.jaxrs;

import com.grupodot.jaxrs.Tasa;
import java.text.NumberFormat;
import java.util.List;

/**
 *
 * @author ander
 */
public class Cotizacion {
    
    private Tasa mejorTasa;   
    private String socio;   
    private double cuota_mensual;    
    private double pago_total;    
    private double tasa_mensual;
    
    public Tasa getMejorTasa() {
        return mejorTasa;
    }

    public void setMejorTasa(Tasa mejorTasa) {
        this.mejorTasa = mejorTasa;
    }

    public double getTasa_mensual() {
        return tasa_mensual;
    }

    public void setTasa_mensual(double tasa_mensual) {
        this.tasa_mensual = tasa_mensual;
    }


    public double getPago_total() {
        return pago_total;
    }

    public void setPago_total(double pago_total) {
        this.pago_total = pago_total;
    }


    public double getCuota_mensual() {
        return cuota_mensual;
    }

    public void setCuota_mensual(double cuota_mensual) {
        this.cuota_mensual = cuota_mensual;
    }


    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }
    
    public String testCotizacion() {
        return "test cot works!";
    }
    
    public String obtenerSocio( int monto, List<Tasa> tasas ) {
        double interes = 100.0;
        String socio = "Null";
        try {
            for (Tasa tasa : tasas) {
                if ( monto <= tasa.getMontoMax() && interes > tasa.getTasa() ) {
                    interes = tasa.getTasa();
                    socio = tasa.getSocio();
                }
            }
            return socio;
        } catch (Exception e) {
            return "error socio";
        }        
    }
    
    public Tasa obtenerMejorTasa( int monto, List<Tasa> tasas ) {
        double interes = 100.0;
        Tasa mejorTasa = new Tasa(new Long(0), "No hay socio disponible", 100.0, 999999999);
        try {
            for (Tasa tasa : tasas) {
                if ( monto <= tasa.getMontoMax() && interes > tasa.getTasa() ) {
                    interes = tasa.getTasa();
                    mejorTasa = tasa;
                }
            }
            return mejorTasa;
        } catch (Exception e) {
            return new Tasa(new Long(0), "No hay socio disponible", 100.0, 999999999);
        }        
    }
    
    public void calcularCoutaMensual( int monto, double tasaInteres ){
        int coutas = 36;
        double interesTotal = Math.round(monto*(tasaInteres/100)*coutas * 100.0)/100.0 ;
        this.pago_total = monto+interesTotal;
        this.cuota_mensual = this.pago_total/coutas;        
    }
    
    public String toXML(){        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String cuotaMensual = formatter.format(this.cuota_mensual);
        String pagoTotal = formatter.format(this.pago_total);         
        return String.format(                
                "<cotizacion>"
                        + "<socio>%s</socio>"
                        + "<cuota>"+cuotaMensual+"</cuota>"
                        + "<total>"+pagoTotal+"</total>"
                        + "<tasa>%f %s</tasa>"
                +"</cotizacion>", this.socio, tasa_mensual, "%" );
    }
    
    public Cotizacion( int monto, List<Tasa> tasas ) {     
        this.mejorTasa = this.obtenerMejorTasa(monto, tasas);
        this.setSocio( mejorTasa.getSocio());   
        this.tasa_mensual = this.mejorTasa.getTasa();
        this.calcularCoutaMensual(monto, this.tasa_mensual);        
    }
}
