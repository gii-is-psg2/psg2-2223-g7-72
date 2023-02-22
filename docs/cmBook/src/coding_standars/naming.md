# Denominación

Los identificadores usan solamente letras y dígitos `ASCII` y, en un pequeño número de casos, guiones bajos. El nombre del archivo de origen consiste en el nombre que **distingue entre mayúsculas y minúsculas** de la clase de nivel superior que contiene, más la
extensión `.java`.

## Nombres de paquetes

Los nombres de los paquetes usan solo **letras minúsculas y dígitos (sin guiones bajos)**. Las palabras consecutivas simplemente se concatenan juntas.

## Nombres de las clases

Los nombres de las clases se escriben en `UpperCamelCase` y suelen ser **sustantivos o frases nominales** de la forma: Character o ImmutableList.

Las clases de prueba tendrán un nombre que terminen con `Test`, por ejemplo: `IntegrationTest`. Si el test está relacionado con una sola clase entonces recibirá el nombre de esa clase seguido de Test.

## Nombres de métodos

Para el caso de los métodos, estos se escribirán en `lowerCamelCase`, pudiendo ser **verbos** o **frases verbales**. Los guiones bajos pueden aparecer en el caso de los nombres de los métodos de prueba.

## Nombres de constantes

En cuanto a las constantes, estas se escribirán en `UPPER_SNAKE_CASE`, es decir, con todas las **letras mayúsculas y las palabras separadas por guiones bajos**.

## Otros nombres y nomenclaturas

Por otro lado, tanto los campos que no son constantes como los parámetros y las variables se nombrarán utilizando de nuevo la estructura `lowerCamelCase`.
