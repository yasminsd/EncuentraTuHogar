# EncuentraTuHogar
# Fase 1
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


# Fase 2
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
   -  Rol Usuario: user@user.com pass
   -  Rol Admin: admin@admin.com adminpass  

Para generar el ejecutable jar es necesario compilarlo. Para ello:  
- Seleccionamos Run As en nuestro proyecto y a continuación Maven Buid. Debemos especificar en el campo Goals "package" y se generará un archivo jar:    
<img src="images/JAR.png" height="300" alt="images"/>  

Ejecutamos el archivo jar ubicado en la carpeta target de nuestro proyecto y la aplicación entrará en funcionamiento.  
  
Para comprobar que la base de datos MySQL se ha conectado con Spring Boot he utilizado la aplicación MySQL Workbench versión 8.0:   
<img src="images/MySQLWorkbench.png" height="300" alt="images"/>   
Con esta aplicación, he comprobado si la aplicación Spring Boot se conectaba o no a la basae de datos de MySQL visualizando las tablas generadas:  
Tabla Usuario  

<img src="images/TablaUsuario.png" height="300" alt="images"/>  
Tabla Anuncio  

<img src="images/TablaAnuncio.png" height="300" alt="images"/>  
Tabla Casa  

<img src="images/TablaCasa.png" height="300" alt="images"/>  
Tabla Compra  

<img src="images/TablaCompra.png" height="300" alt="images"/>  
Tabla Venta  

<img src="images/TablaVenta.png" height="300" alt="images"/>  

Otra herramienta que he utilizado, sobre todo al principio, es Postman con la que podemos realizar las operaciones CRUD (Crear,Leer, Actualizar y Borrar) sobre las bases de datos relacionales y comprobar si los métodos están realizados correctamente.   

<img src="images/Postman.png" height="300" alt="images"/>  

# Fase 3
En esta última fase vamos a utilizar balanceadores de carga para que pueda tener múltiples servidores.
El balanceador de carga va a estar escuchando en una IP en el puerto 80.

Para realizar el despliegue de la aplicación vamos a utilizar una máquina virtual. 
La idea es levantar los siguientes procesos: 
- Una instancia del balanceador de carga (HAproxy) 
- Dos instancias de la aplicación web 
- La base de datos 
 





