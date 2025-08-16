# 💱 Challenge Conversor de Moneda

Este proyecto forma parte del programa **Oracle Next Education (ONE)** en colaboración con **Alura Latam**. El objetivo fue desarrollar un conversor de monedas en Java, integrando una API externa para obtener tasas de cambio en tiempo real.

---

## 🚀 Funcionalidades

- Menú interactivo en consola para seleccionar conversiones
- Conversión entre distintas monedas latinoamericanas y el dólar
- Consumo de API externa usando `HttpClient`
- Deserialización de JSON con `Gson`
- Manejo de errores y validación básica
- Código modular y extensible

---

## 🧠 Tecnologías utilizadas

- `HttpClient` para solicitudes HTTP
- `Gson` para análisis de JSON
- API: [ExchangeRate API](https://www.exchangerate-api.com/)
- IDE: IntelliJ / VS Code

---

## 🧩 Estructura del proyecto

ConversorApp.java
    - Clase principal que inicia la ejecución del programa.

ConversorMenu.java
    - Presenta el menú interactivo en consola y gestiona la entrada del usuario.

CurrencyConverterService.java
    - Encapsula la lógica de conexión con la API externa y realiza las conversiones.

ExchangeRateResponse.java
    - Modelo de datos que representa la respuesta JSON obtenida desde la API.

## 🌎 Monedas soportadas

- ARS — Peso argentino  
- BRL — Real brasileño  
- CLP — Peso chileno  
- COP — Peso colombiano  
- USD — Dólar estadounidense  

---

## 📷 Ejemplo de uso

```bash
Sea bienvenido/a al Conversor de Moneda =]
1) Dólar => Peso argentino
2) Peso argentino => Dólar
...
Elija una opción válida: 1
Ingrese el monto a convertir: 100
100 USD son 90000 ARS