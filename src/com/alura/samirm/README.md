# Conversor de Moneda

Este proyecto es un conversor de moneda desarrollado en Java que se conecta a una API para obtener tasas de cambio y permite convertir entre diferentes monedas.

## Funcionalidades

- Conversión de Moneda: Convierte un valor de una moneda a otra usando tasas de cambio en tiempo real.
- Interfaz de Menú: Ofrece una interfaz de texto para seleccionar monedas y la cantidad a convertir.

## Estructura del Proyecto
El proyecto está organizado en las siguientes clases:

1. ConversorMoneda y Clase principal: gestiona las tasas de cambio y realiza la conversión.
2. ApiClient: Clase que conecta con una API para obtener las tasas de cambio.
3. Moneda: Clase que representa una moneda y su tasa de cambio.
4. Menu: Clase que interactúa con el usuario para seleccionar las monedas y la cantidad.

## Requisitos
- Java 11 o superior
- Biblioteca Gson: Para el manejo de datos JSON en la API.

## Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/samirmartinez1984/challenge-conversor.git

# uso:
1.  Ejecuta el programa.
2. selecciona la moneda origen y la moneda destino.
3. Ingresa la cantidad que deseas convertir.
4. El programa te mostrara la cantidad de modedas convertidas segun la tasa de cambio actual.
