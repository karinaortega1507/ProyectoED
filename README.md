# ProyectoED 

# Introducción
Flavio Josefo fue un historiador judío que vivió en el siglo primero. En cierta ocasión, Josefo y cuarenta de sus
soldados quedaron atrapados en una cueva mientras eran asechados por el ejército romano. Antes que ser
capturados y convertidos en esclavos, Josefo y su gente prefirieron morir y establecieron un método para
suicidarse en serie.
En este proyecto, usted implementará una aplicación gráfica de JavaFX que simule la forma en que este
suicidio colectivo pudo haber ocurrido. Como parte del diseño de su solución, usted deberá decidir cuáles de
las estructuras de datos revisadas en el curso hasta ahora son las más apropiadas para implementar la
simulación que se solicita.


# Mecanismo de Eliminación
Se cree que Josefo no era partidario de la auto eliminación y, para evitarla a toda costa, encontró una solución
imaginativa. Propuso a sus compañeros que debían formar un círculo y matarse entre ellos siguiendo un ritual
matemático: el primero mataría al segundo y pasaría la espada al tercero, el cual acabaría con el cuarto, y
pasaría luego la espada al quinto y así sucesivamente. Así, en el último round de este proceso, solo dos
personas quedarían vivas: una con la responsabilidad de eliminar a la otra. De esta forma, el “azar” elegiría al
judío que no tendría más remedio que suicidarse luego de eliminar a su último compañero vivo.
Se cree que, con este juego matemático, Josefo esperaba salir con vida de la cueva. Según la historia, Josefo
calculó rápidamente el lugar que debían ocupar los dos últimos sobrevivientes. Una de estas posiciones la
eligió para sí mismo y la otra para uno de sus mejores amigos.

# Modelamiento del Problema
Como probablemente habrá notado, el escenario descrito arriba puede ser modelado con una lista circular de
personas que pueden estar vivas o muertas. Dados los objetivos que se persiguen en este curso, usted y ssu
compañeros de grupo serán responsables de implementar los TDAs que consideren pertinentes para la
solución de este problema. El uso de las clases ArrayList y LinkedList de Java queda explícitamente
prohibido. Ignorar esta prohibición invalidaría su proyecto y le otorgaría una nota de cero puntos.
Su simulación debe consistir en una interfaz gráfica de JavaFX que permita al usuario controlar los siguientes
parámetros:
1. El número de personas que componen el grupo
2. El número (o posición) de la persona que comienza el procedimiento de ejecución
3. La dirección del orden de ejecución (derecha o izquierda)
Estos parámetros deben ser indicados por el usuario utilizando controles gráficos (por ejemplo, sliders) y la
interfaz debe responder, apropiadamente, a los cambios hechos por el usuario. Por ejemplo, si el número de
personas que componen el grupo es modificado, la interfaz debe actualizarse como corresponda (mostrando
más –o menos– personas).
La interfaz debe también tener un botón que permita, una vez indicados todos los parámetros necesarios,
ejecutar la simulación. Al presionar este botón, su aplicación deberá mostrar como progresa la ejecución. En
cada paso, debe ser evidente qué persona realiza la ejecución y qué persona es ejecutada.
Al final, su simulación debe indicar qué persona del grupo es la última en quedar con vida.

# Funcionalidad Opcional
Este proyecto es una excelente oportunidad para poner en práctica sus conocimientos desarrollados en el
curso de Estructuras de Datos. Asimismo, es una oportunidad para ser creativo, implementando funcionalidad
extra que contribuya a una mejor animación del problema de Josefo.
A continuación, se muestra una lista de algunas de las funcionalidades opcionales que usted y sus compañeros
de grupo podrían implementar para aplicar a puntos adicionales:
▪ Añadir elementos a la interfaz para controlar la reproducción de la simulación (botones de pause,
resume y reset, por ejemplo).
▪ Permitir que el usuario indique qué personas del grupo son inmortales. Una persona inmortal no
puede ser asesinada. Por tanto, cuando alguien intente asesinar a una persona inmortal, la animación
debe informar de alguna manera sobre este evento y asignar, automáticamente, a la siguiente
persona viva en la dirección correspondiente como la próxima a ser ejecutada.
▪ Penalizar a quien intente asesinar a una persona inmortal. Por ejemplo, castigándola con la muerte y
mostrando esto apropiadamente en la animación.
▪ Animar el paso de la espada de una persona a otra.
▪ Cualquier otra funcionalidad que consideren relevante y útil para este proyecto.

# Entregable
El proyecto de Netbeans que implemente la interfaz gráfica final de su proyecto, con todas las funcionalidades
detalladas anteriormente, debe ser entregado hasta las 11:59 pm del domingo 01 de diciembre de 2019.
Su entrega debe incluir un video (grabado con celular horizontalmente o con un software para capturar
pantallas) que incluya una narración oral de su proyecto en funcionamiento. El video debe también describir
cualquier funcionalidad adicional que usted y sus compañeros de grupo hayan implementado. El video debe
ser subido a YouTube. Asegúrese de verificar que el video publicado puede ser accedido por cualquier usuario
que disponga el link correspondiente. No lo publique como privado.
Finalmente, su entrega debe incluir un archivo .docx con screenshots de su interfaz y con la URL del video
explicativo subido a YouTube. La plantilla para este documento será entregada oportunamente.
El proyecto y el archivo .docx deben ser entregados a través de SidWeb en un único archivo comprimido .zip.
Solo en caso de que SidWeb presente problemas técnicos, usted deberá alojar su archivo de respuesta (un
archivo .zip) en una carpeta compartida de Google Drive. En este caso, usted deberá enviar un correo
electrónico a la dirección gmendez@espol.edu.ec indicando el link de la carpeta compartida. Asegúrese de
probar que su link funcione sin necesidad de permisos especiales. Asimismo, asegúrese de no sobrescribir el
contenido de la carpeta después de la hora máxima de entrega, puesto que, de otro modo, la hora de entrega
de su respuesta reflejará esta sobre-escritura en la metadata de la carpeta (leer texto en rojo abajo).
