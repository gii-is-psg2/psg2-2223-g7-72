# Features

Para implementar nuevas funcionalidades se debe abrir una nueva rama `feature` desde la última versión de `develop`. Cuando la nueva función esté terminada, se fusionará  en `develop` pero no deben interactuar directamente con `main`. Desde la rama `develop` se hará merge[^merge] a la rama `feature`, será necesario realizar un `PULL-REQUEST` antes del `merge`[^merge]. Además se usará la opción `--no-ff` del `merge`[^merge] para realizar un merge commit separado al fusionar los cambios introducidos en `feature` y `develop`.

Nomenclatura: `feature/{numeroIssue}-{nuevaFuncionalidad}`
Ejemplos:

- `feature/18-pethotel`
- `feature/30-cmBook`
- `feature/22-translations`

[^merge]: Comando para hacer merge (antes hay que posicionarse en la rama `develop`):
`git merge --no-ff feature/{numeroIssue}-{nuevaFuncionalidad}`
