# EncuentraTuHogar
Aplicación Web de compra/venta de casas.


Descripción lógica de las entidades:
- Administrador
   - Esta entidad almacena los datos de los usuarios gestionando su alta y baja del sistema.
- Usuario
   - Esta entidad posee los datos relevantes que debe poseer un usuario registrado en el sistema para poder realizar una compra o una venta de una casa.
- Compra
   - Almacena los datos que tienen relación con la compra de una casa.
- Venta
   - Almacena los datos que tienen relación con la venta de una casa.
- Casa
   - Almacena los datos que tiene relación con todas las casas.




Integrante:  
Nombre: Yasmin  
Apellidos: Shekh Liébana  
E-mail: y.shekh@alumnos.urjc.es  
Git: https://github.com/yasminsd/EncuentraTuHogar   
Tablero Trello: https://trello.com/encuentra_tu_hogar 


Fase 2  
Diagrama de clases UML  
<img src="images/DiagramaUML.png" height="500" alt="images"/>  
Diagrama Entidad/Relación  
<img src="images/ModeloER.png" height="500" alt="images"/>  
Instruciones específicas para desplejar la aplicación:
- Los requisitos para ejecutar la aplicación son :
   - Java 11  
   - OpenJDK Java 11  
   - MySQL 8.0  
- Los datos para iniciar la aplicación son:
   -  Rol Usuario: user pass
   -  Rol Admin: admin adminpass  

Para generar el ejecutable jar es necesario compilarlo. Para ello:  
- Seleccionamos Run As en nuestro proyecto y a continuación Maven Buid. Debemos especificar en el campo Goals "package" y se generará un archivo jar:    
<img src="images/JAR.png" height="500" alt="images"/>  





