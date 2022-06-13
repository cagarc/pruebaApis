# PREPARAR EL AMBIENTE 

##Herramientas<br>
 	--Utilizar el IDE de desarrollo de Java de su preferencia  <br>
 	--Tener instalado spring boot en su IDE<br>
 	--Tener instalado Java 1.8<br>
 	--Tener instalado Postgresql<br>
 
##Levantamiento de servicio <br>

Tener la base de datos con la siguiente configuracion <br>
Base: postgres, usuario:postgres, password:root <br>
Luego de levantar el servicio , puede ingresar a la siguiente url [servicio empleado](http://localhost:8080/swagger-ui/#/)  <br>
tambien puede utiliza el proyecto postman que se encuentra en la raiz del proyecto PruebaK.postman_collection.json <br>
para realizar pruebas

# Swagger generated server

Spring Boot Server 


## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.

The underlying library integrating swagger to SpringBoot is [springdoc-openapi](https://github.com/springdoc/springdoc-openapi)

Start your server as an simple java application  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties