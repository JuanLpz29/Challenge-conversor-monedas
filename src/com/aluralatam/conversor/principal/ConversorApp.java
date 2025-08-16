package com.aluralatam.conversor.principal;

import com.aluralatam.conversor.features.ConversorMenu;
import com.aluralatam.conversor.features.CurrencyConverterService;

public class ConversorApp {
    public static void main(String[] args) {
        CurrencyConverterService service = new CurrencyConverterService("3d6d5ae23a5eb80da80ee6d3");
        ConversorMenu menu = new ConversorMenu(service);
        menu.mostrarMenu(); // Aquí se lanza el menú interactivo
    }
}

