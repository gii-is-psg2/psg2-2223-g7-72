# Política de mensajes de commit

Para la correcta realización de los commits por parte del equipo de desarrollo se darán unas pautas y reglas que indicarán la forma correcta de escribir los mensajes de estos.

Las reglas a cumplir son las siguientes:

- En caso de que se incluya cuerpo o pie de página, ambos obligatoriamente se escribirá con un salto de línea tras lo que lo preceda.
- El asunto no podrá superar los 50 caracteres.
- El cuerpo deberá ser de máximo 72 caracteres.
- No concluir la descripción con un punto final pero sí el cuerpo.
- Usar el imperativo en la descripción.
- Se escribirá la descripción completa en minúsculas y el cuerpo empezará por mayúscula.
- En el cuerpo se explicará el qué y el por qué de las modificaciones realizadas en ese commit.
- Será obligatorio indicar el tipo de commit.

Adicionalmente se indica la estructura que deberán tener estos mensajes:

```text
    <tipo>[alcance opcional]: <descripción>
    [cuerpo opcional] 
    [pie(s) de página opcional]
```

Se utilizarán estos tipos en los commits:

- `fix`: se indica como tipo cuando se corrigen bugs en el código fuente.
- `feat`: se especifica al añadir una nueva funcionalidad.
Otros tipos son también: `build`, `chore`, `ci`, `docs`, `style`, `refactor`, `perf`, `test`.

Se añadirá `!` después del tipo si el commit contine algún cambio de ultima hora o importante. En este último caso se podrá indicar en el pie de página escribiendo *BREAKING CHANGE:* y seguido de una descripción. También se pueden incluir mensajes como `Fixes #issue`, `Refs #issue`.

Algunos ejemplos de mensajes de commit serían:

- Mensaje de commit con descripción y breaking change en su pie de página

```text
feat: añadido compra de productos para mascotas

BREAKING CHANGE: la clave ‘compra’ del archivo config ahora asigna las
compras al cliente correspondiente.
```

- Mensaje de commit con alcance y !

```text
feat(api)!: envío de correo al cliente que pida una visita
```

- Mensaje de commit con cuerpo y pie de página

```text
fix: solucionado el solapamiento de solicitudes

Se introducirá una ID de solicitud y una referencia de la última
solicitud para solucionar los tiempos de espera en las solicitudes.

Fixes: #45
Refs: #123
```
