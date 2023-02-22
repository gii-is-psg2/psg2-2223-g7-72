# Release

La rama `release` se utilizará para preparar el siguiente código listo para producción, en ella se harán los últimos ajustes (archivos de configuraciones, archivos de librerias, pequeñas correcciones) antes de incorporar el código a la rama `main`. Además los cambios también se incorporarán a la rama `develop`. Al incorporarlo a `main` se etiqueta con una versión.

Nomenclatura: `release/v{versiónDeRelease}`
> Nota: La versión de release se corresponde con la versión de la rama develop en el momento que se bifurcó la rama

Ejemplo: `release/v0.0.0` (Esta rama parte de la rama `develop` v0.0.0. Una vez se realiza el merge con la rama `develop`, la rama `develop` pasa a ser v1.0.0, la rama `main` también aumenta su versión al hacer merge con ella  y además se crea una TAG).
