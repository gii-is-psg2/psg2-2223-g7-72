# Formateo

## Empleo de llaves

Las llaves `{}` se utilizarán en las declaraciones `if`, `else`, `for`, incluso cuando el cuerpo esté vacío o contenga una sola declaración.

Para las llaves hay que tener en cuenta lo siguiente:

- Ningún salto de línea antes de la llave de apertura.
- Salto de línea después de la llave de apertura
- Salto de línea antes de la llave de cierre.
- Salto de línea después de la llave de cierre solo si esa llave termina una declaración o el cuerpo de un método, constructor o clase con nombre.

## Indentación de bloques y estructuras

Para la indentación de los bloques, en lugar de espacios se utilizará la tabulación para agilizar el proceso y el formateo de estas estructuras.

## Número de declaraciones

Una declaración por línea.

```java
    int a;
    int b; 
```

En lugar de:

```java
    int a,b;
```

**Excepción:** Se podrán utilizar multiples declaraciones de variables en el encabezado de un bucle `for`.

## Anotaciones

Las anotaciones aparecerán situadas en la cabecera, independientemente si se trata de una clase o un método.

```java
    @Service
    public class OwnerService {
        private OwnerRepository ownerRepository;

        @Autowired
        private UserService userService;

        @Autowired
        private AuthoritiesService authoritiesService;

        @Autowired
        public OwnerService(OwnerRepository ownerRepository) {
            this.ownerRepository = ownerRepository;
        }
    }
```

## Comentarios

Los comentarios se tabularán al mismo nivel que el código circundante.

```java
    //Esto es un comentario
    int maxValue;
```

Podrán utilizarse tanto comentarios del estilo `/*...*/` como el estilo `//`. Para los comentarios de varias líneas, `/*...*/`, las siguientes líneas deberán comenzar alineadas con la línea anterior.

```java
    //Esto es un comentario
    /* Esto es un comentario
    con varias
    lineas
    */
```

 En cualquier caso, **evitar el uso de comentarios en la medida de lo posible**, minimizando así la cantidad de estos elementos a lo largo del código.
