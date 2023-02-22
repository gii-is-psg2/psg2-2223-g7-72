# Política de mensajes de commit

Para la correcta realización de los commits por parte del equipo de desarrollo se darán unas pautas y reglas que indicarán la forma correcta de escribir los mensajes de estos.

Las reglas a cumplir son las siguientes:

- Separar el asunto del cuerpo del mensaje por una línea en blanco.
- El asunto no podrá superar los 50 caracteres.
- El primer carácter despues del tipo del commit deberá ir con mayúsculas.
- No concluir el asunto con un punto final.
- Usar el imperativo en el asunto.
- El cuerpo deberá ser de máximo 72 caracteres.
- En el cuerpo se explicará el qué, el por qué de las modificaciones realizadas en ese commit.

Adicionalmente se indica la estructura que deberán tener estos mensajes:

```text
    <tipo>[alcance opcional]: <descripción>
    [cuerpo opcional] 
    [pie(s) de página opcional]
```

Se utilizarán estos tipos en los commits:

- `fix`: se indica como tipo cuando se corrigen bugs en el código fuente.
- `feat`: se especifica al añadir una nueva funcionalidad.
Otros tipos son también: `build`, `chore`, `docs`, `refactor`, `test`…

Se añadirá `!` después del tipo si el commit contine algún cambio importante. En este último caso se podrá indicar en el pie de página escribiendo “BREAKING CHANGE:” y seguido de una descripción. También se pueden incluir mensajes como “Fixes #issue”, “Resolves #issue”.

Ejemplos:

```bash
feat(pethotel): Add booking system to pets
```

```text
feat(api)!: Change route get pet listing

BREAKING CHANGE: The api no loger works with /get/petlisting changed to /pets
```

```text
test(pethotel): Add a suite of test to pethotel
```
