en este paquete debe ir la clase de arranque del proyecto anotada con @SpringBootApplication
Para que funcione, como las propiedades de configuración van en un directorio config/application.properties
y config/desarrollo/application.properties, y además externalizadas, se debe arrancar
la aplicación con los parámetros de la JVM como se muestra a continuación (ejemplo para ejecución dentro de eclipse) 
-Dspring.config.location=${workspace_loc}/target/config/desarrollo/application.properties,${workspace_loc}/target/config/application.properties