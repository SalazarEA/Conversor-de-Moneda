package com.alura.conversordemoneda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.MonthDay;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Panel {


    public void eleccion() {
        Scanner scanner = new Scanner(System.in);
        Moneda moneda1 = new Moneda();



        int option = 0;
        while (option != 11) {

            String base = moneda1.getMonedaBase();
            String convertir = moneda1.getMonedaConvertir();
            double valor = moneda1.getValorConvertir();
            try {



            System.out.println("               Convertidor de monedas");
            System.out.println("***************************************************");
            System.out.println("1. Convertir Dolar Estadounidense a Peso Argentino");
            System.out.println("2. Convertir Peso Argentino a Dolar Estadounidense");
            System.out.println("3. Convertir Dolar Estadounidense a Boliviano");
            System.out.println("4. Convertir Boliviano a Dolar Estadounidense");
            System.out.println("5. Convertir Dolar Estadounidense a Real Brasileño");
            System.out.println("6. Convertir Real Brasileño a Dolar Estadounidense");
            System.out.println("7. Convertir Dolar Estadounidense a Peso Chileno");
            System.out.println("8. Convertir Peso Chileno a Dolar Estadounidense");
            System.out.println("9. Convertir Dolar Estadounidense a Peso Colombiano");
            System.out.println("10. Convertir Peso Colombiano a Dolar Estadounidense");
            System.out.println("11. Salir");
            System.out.println("*******************************************************");
            System.out.println("*******************************************************");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    moneda1.setMonedaBase("USD");
                    moneda1.setMonedaConvertir("ARS");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 2:
                    moneda1.setMonedaBase("ARS");
                    moneda1.setMonedaConvertir("USD");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 3:

                    moneda1.setMonedaBase("USD");
                    moneda1.setMonedaConvertir("BOB");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 4:

                    moneda1.setMonedaBase("BOB");
                    moneda1.setMonedaConvertir("USD");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 5:

                    moneda1.setMonedaBase("USD");
                    moneda1.setMonedaConvertir("BRL");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 6:

                    moneda1.setMonedaBase("BRL");
                    moneda1.setMonedaConvertir("USD");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 7:

                    moneda1.setMonedaBase("USD");
                    moneda1.setMonedaConvertir("CLP");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 8:

                    moneda1.setMonedaBase("CLP");
                    moneda1.setMonedaConvertir("USD");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 9:

                    moneda1.setMonedaBase("USD");
                    moneda1.setMonedaConvertir("COP");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 10:

                    moneda1.setMonedaBase("COP");
                    moneda1.setMonedaConvertir("USD");
                    System.out.println("Cuanto desea convertir");
                    moneda1.setValorConvertir(scanner.nextDouble());
                    break;
                case 11:
                    System.out.println("Hasta Luego");
                    return;
                default:
                    System.out.println("Escriba una opcion correcta");
                    return;

            }
            }catch (InputMismatchException e){
                System.out.println("Escriba el metodo correcto solo numeros");
                eleccion();
                return;
            }
            String direccion = "https://v6.exchangerate-api.com/v6/9c93dd699f19c9247653b16b/pair/" + moneda1.getMonedaBase() +
                    "/" + moneda1.getMonedaConvertir() + "/" +
                    moneda1.getValorConvertir() + "/";

            Gson gson = new GsonBuilder().create();
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();


            HttpResponse<String> response;

            {
                try {
                    response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();

                    Monedas monedas = gson.fromJson(json, Monedas.class);

                    moneda1 = new Moneda(monedas);
                    System.out.println(moneda1);

                } catch (IOException | InterruptedException e ) {
                    throw new RuntimeException(e);
                }
        }
    }
}}

