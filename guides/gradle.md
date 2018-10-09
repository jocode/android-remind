# Gradle

Es una herramienta para automatizar el proceso de construcción de nuestros proyectos. Fué desarrollada por Google y se basa en una herramienta llamada Groovy, que tiene una sintaxis muy similar a Java.

Cuando compilamos software, *gradle* verifica si hay cambios en el código fuente respecto a la última compilación, de esta forma de ahorra la tarea de volver a compilar.

Además de eso, hace uso de gestores de paquetes como maven, que nos permiten usar librerías de terceros para incluirlas en nuestro proyecto.
Gradle gestiona la versiones del proyecto, y los target de los dispositivos para los cuales estamos desarrollando.

Generalmente en los proyectos de Android, nos encontramos con dos archivos llamados `build.gradle` y `settings.gradle`. Estos archivos son los que gestionan las dependencias de nuestros proyectos y mantenemos las versiones del código de hayamos puesto como release.

En gradle para Android, siempre se usa la línea `apply plugin: 'android'`

En la propiedad `default config`, definimos la versión mínima de Android que vamos a soportar, y la versión target (objetivo) en el cuál vamos a compilar,  por lo general es la última versión que dispongamos.

Eñ `versionCode` es la versión numérica de nuestra aplicación, ésta se cambia cada vez que hacemos un deploy de nuestra aplicación. El `versionName` es la versión que el usuario ve como la versión disponible en la tienda de Aplicaciones, por ejemplo `1.0.1`. Estos valores son independientes, sin embargo cuando la subamos a la PlayStore, debemos cambiar estos 2 valores.

En `dependencies` definimos las librerías que vamos a utilizar en nuestro proyectos, estas generalmente se cargan de *maven central* o *github*, pero también podemos incluir archivos `.jar`, es decir librerías ya compiladas en nuestro proyecto.

> Importante, que las versiones de las compilaciones sean versiones absolutas, es decir. Nunca tenga + (v7:19.+). Es recomendable siempre usar números con una versión completa, que termine en un entero.