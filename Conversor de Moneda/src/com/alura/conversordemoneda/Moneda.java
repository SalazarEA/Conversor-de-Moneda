package com.alura.conversordemoneda;

public class Moneda  {

    private String monedaBase;
    private String monedaConvertir;
    private double valorConvertir;
    private double valorMoneda;
    private double resultado;

    public Moneda(String monedaBase, String monedaConvertir, double valorConvertir) {
        this.monedaBase = monedaBase;
        this.monedaConvertir = monedaConvertir;
        this.valorConvertir = valorConvertir;
    }


    public Moneda(Monedas monedas) {
        this.monedaBase = monedas.base_code();
        this.monedaConvertir = monedas.target_code();
        this.valorMoneda = monedas.conversion_rate();
        this.resultado = monedas.conversion_result();
    }

    public Moneda() {

    }


    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaConvertir() {
        return monedaConvertir;
    }

    public void setMonedaConvertir(String monedaConvertir) {
        this.monedaConvertir = monedaConvertir;
    }

    public double getValorConvertir() {
        return valorConvertir;
    }

    public void setValorConvertir(double valorConvertir) {
        this.valorConvertir = valorConvertir;
    }


    public String toString() {
        return
                "Se cambian " + monedaBase +
                " a " + monedaConvertir +
                "\nla cotizacion del dia es: " +  valorMoneda+
                "\ny son: " + resultado +" "+ monedaConvertir ;
    }

}

