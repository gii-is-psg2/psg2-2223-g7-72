# Features

Para implementar nuevas funcionalidades se debe abrir una nueva rama `feature` desde la última versión de `develop`. Cuando la nueva función esté terminada, se fusionará  en `develop` pero no deben interactuar directamente con `main`. Desde la rama `develop` se hará merge[^merge] a la rama `feature`, será necesario realizar un `PULL-REQUEST` antes del `merge`[^merge]. Además se usará la opción `--no-ff` del `merge`[^merge] para no eliminar la rama `feature`.

Nomenclatura: `feature/{nuevaFuncionalidad}`
Ejemplo: `feature/vistaCliente`

[^merge]: Comando para hacer merge (antes hay que posicionarse en la rama `develop`): `git merge --no-ff feature/{nuevaFuncionalidad}`
