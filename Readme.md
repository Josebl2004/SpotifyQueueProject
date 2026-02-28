#Simulacion de Spotify con Cola FIFO en Java

Descripcion: el proyecto consiste en el diseno e implemetacion de una simulacion de reproduccion de canciones tipo spotify utilizanod una estructura de datos cola.
Se implemento con Maven, con una libreria propia que contiene la estructura de datos Queue.
Consumir mediante un simulador que reproduce las canciones con prioridad 1 o 2.

La estructura del repositorio segun lo indicado queda:
/queue
/queueHandler
/Readme.md
/evidencias

Libreria de cola propia.
Se implemento una estructra de datos manual basada en modos enlazados, con una clase generica Queue, Clase interna Node, Referencias privadas como head y tail y una variable interna size.
Con metodos implementados: enqueue, dequeue, peek, isEmpty, size.
Para compilar esta libreria desde la carpeta: queue, ejecutar mvn clean install. (esto instalara la libteria en el repositorio local .m2)

*Simulacion de reproduccion*

Este proyecto consume la libreria anterior como dependencia de Maven.
Cada cancion (Song) contiene title, artist, duration (de 5 a 30 segundos), priority (1=alta, 2=normal) todas las duraciones son variables entre ese intervalo.
Se muestran logs en la consola indicando: 
-Inicio de la playlist
-Cancion actual
-Progreso por segundo 
-Finalizacion de cada cancion
-finalizacion total.

*Sistema de Prioridad*

Se implemnte la prioridad utilizando dos colas internas: una de prioridad alta y una de prioridad normal. De modo que primero se reproduciran las canciones de prioridad 1 y luego las de prioridad 2 respetando el orden FIFO dentro de cada grupo.

*Extensiones Implementadas*

-Historial de canciones reproducidas
-Contador total de canciones reproducidas
-Tiempo total acumulado
-Barra de progreso visual

*Compilacion del Handler*

Entrar a la carpeta desde la consola: /queueHandler
ejecutar: mvn clean package (para compilar nuestro proyecto)
desdepues de compilar ejecutar: java -jar target/queueHandler-0.0.1-SNAPSHOT.jar

*Evidencias*
las evidencias de la compilacion del handler,de la libreria y de la ejecucion del programa se quedan dentro de la carpeta /evidencias

*Decisiones Tecnicas*
Se decidio usar dos colas internas para implementar el sistema de prioridad, ya que permite mantener el orden FIFO que se nos solicita sin utilizar estructuras JDK, y se utilizo Thread.sleep(1000) para simular la duracion real de las canciones



