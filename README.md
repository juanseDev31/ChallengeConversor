# Conversor de Moneda en Java 💱

Este es un proyecto en Java que permite convertir entre diferentes monedas usando la API de [ExchangeRate API](https://www.exchangerate-api.com/).

## Características

- Conversión entre:
  - Dólar y Peso argentino
  - Dólar y Real brasileño
  - Dólar y Peso colombiano
- Tasas de cambio actualizadas en tiempo real
- Interfaz por consola
- Implementado con Maven y Gson

## Requisitos

- Java 11 o superior
- IntelliJ IDEA (opcional)
- Conexión a Internet
- Una API Key de [ExchangeRate API](https://www.exchangerate-api.com/)

## Configuración

1. Crea un archivo llamado `config.properties` dentro de la carpeta `src/main/resources`.
2. Agrega tu API key:

```properties
api.key=TU_API_KEY
