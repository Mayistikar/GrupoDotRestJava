# Test Java Backend RestAPI - GrupoDot

El siguiente repositorio guarda el código de la prueba del Grupo Dot. En este se encuentra la fuente de un Rest que responde XML según las especificaciones de la prueba.

# Negocio

La creación del REST se realizó con asistencia Netbeans y siendo los archivos principales los siguientes:

## /src/java/com/grupodot/jaxrs/Cotizacion.java
Es el archivo que maneja la lógica y realiza los cálculos.

## /src/java/com/grupodot/jaxrs/Tasa.java
Es el archivo JPA que mapea la única tabla en base de datos con las tasas Ver archivo tasa.sql.

## /src/java/com/grupodot/jaxrs/service/TasaFacadeREST.java
El archivo que maneja las peticiones.

# Observaciones

Lamentablemente, debido a mi actual trabajo y el tiempo que me dieron para desarrollar la prueba no fue posible hacer algunas pruebas unitarias, ni tampoco corregir algunos fallos.
