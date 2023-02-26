# Política de control de versiones

En este apartado se discutirá sobre las políticas de versionados que emplearemos a lo largo de la asignatura.

Hemos decidido adoptar la base del versionado semántico para construir nuestra metodología.
De acuerdo a la especificación se cumplirán estas normas:

- Un número de versión normal **DEBE** tener la forma siguiente `X.Y.Z` donde la `X`, `Y` y `Z` son números enteros no negativos y no deben ir acompañados de un cero por delante. Esto está bien `1.11.0` y esto está mal `01.2.1` o `-0.1.5`.
- Cuando un **paquete** con su número de versión se haya **publicado**, los **contenidos** de su **versión NO** pueden ser modificados bajo ningún concepto. Los cambios introducidos se deben reflejar como una nueva versión del paquete.
- La versión de parche `Z` `x.y.Z` **SÓLO** se puede **modificar** en el caso de que se introduzcan **correcciones** de **errores** que **NO rompan** la **funcionalidad implementada**. Se considera un **bug** aquellos **errores internos** que introducen **comportamientos inesperados** en la aplicación.
- La versión menor `Y` `x.Y.z` **DEBE incrementarse** si se **introduce nueva funcionalidad COMPATIBLE**  en la aplicación, es decir, que **NO rompa** la **funcionalidad anterior**. Se **DEBE incrementar** el número de **versión menor** si alguna funcionalidad se marca como en **desuso**. Se **DEBE incrementar** el número si se introducen **mejoras** o **cambios sustanciales** en la aplicación. La **versión** de parche **DEBE reiniciarse** a `0` cuando se **incremente** el **número de versión menor**.
- La versión mayor `X` `X.y.z` **debe incrementarse** si se **introducen cambios** que **ROMPEN** la **COMPATIBILIDAD** hacia atrás de la aplicación. Cuando se **incremente** este **número** la **versión menor** y la de **parche** debe **reiniciarse** a `0`.
- El **orden** de las **versiones DEBE** calcularse mirando el valor numérico correspondiente a la versión mayor, menor y de parche en ese orden. La **versión mayor** tiene **más peso** que la **menor** y de **parche**, y la **menor** tiene **más peso** que la versión de **parche**. Por ejemplo `1.0.0` < `2.0.0` < `2.1.0` < `2.1.1`.
- Como convención adicional a cada **lanzamiento** se incluirá un *alias* que identificará a la versión publicada. Se utilizarán **nombres de mascota** para nombrar a las releases.
