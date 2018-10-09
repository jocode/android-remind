# Android Debug Bridge 

Android Debug Bridge (ADB) es una herramienta de líneas de comandos versátil que te permite comunicarte con una instancia de un emulador o un dispositivo Android conectado.

*Más información* [Android Debug Bridge ](https://developer.android.com/studio/command-line/adb?hl=es-419#move)

Para usar esta herramienta por la terminal, debemos tener habilitada la depuración USB en nuestro dispositivo.

Luego debemos acceder al directorio donde tenemos instalado el Android SDK `android_sdk/platform-tools/` y a la carpeta *platform-tools/*

Estando aquí ya podemos ejecutar el comando **adb**

- **adb devices** Muestra el listado de dispositivos conectados.

*Conectando un dispositivo a través de WIFI*
Para conectarlo hacemos lo siguiente
- Conecta el dispositivo a la computadora host con un cable USB.
- Configura el dispositivo de destino para que busque una conexión TCP/IP en el puerto 5555. Mediante el siguiente comando.

- **adb tcpip 5555** Configura el dispositivo usando el protocolo TCPIP  en el puerto 5555

- **adb connect device_ip_address** Conecta el dispositivo identificandolo por la IP de la red

Listo, ya se mostrará el dispositivo para la depuración a través de WIFI.


- **adb kill-server** restablece el host ADB, en caso de que se pierda la conexión. Se debe hacer todo igual desde el principio.