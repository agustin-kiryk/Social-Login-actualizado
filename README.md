# Social Login
## Iniciar sesion con Google y Facebook utilizando Java , Springboot y Spring Security Oauth2

## Comenzando 🚀


_Esta API rest permite poder iniciar sesion en una web mediante Google y Facebook.
Guardando en una base de datos los usuarios visitantes de la misma.
Los datos a guardar son :_
- Nombre de usuario
- Email
- Foto de perfil

_Los datos se guardan automaticamente con solo iniciar sesion en cualquiera de las opciones._

_Se hizo foco en el backend de la aplicacion._

### Construccion 🔧

_El modelado de la base de datos con sus respectivas relaciones se realiza automaticamente con JPA e Hibernate al levantar la aplicacion.
Dentro del proyecto en la carpeta **resources/application.properties** se debe colocar su url con la ubicacion de su base de datos, usuario y contraseña, como el siguiente ejemplo._
```
- spring.datasource.url=jdbc:mysql://localhost:3306/NOMBREBDD
```
```
- spring.datasource.username=USUARIO
```
```
- spring.datasource.password=CONTRASEÑA
```

_En este caso se usó Mysql, local host y el puerto 3036_

### ID de cliente y clave de seguiridad OAUTH2 🔒
_Es necesario utilizar la consola de google developer y Facebook developer, para registrasrse y obtener las credenciales para el inicio de sesion de tipo OAuth2._

_Dentro del proyecto en la carpeta **resources/application.properties** se debe colocar su ID de cliente y contraseña para cada servicio, como el siguiente ejemplo._
```
spring.security.oauth2.client.registration.google.client-id=<YOUR GOOGLE CLIENT ID>
spring.security.oauth2.client.registration.google.client-secret=<YOUR GOOGLE CLIENT SECRET>
spring.security.oauth2.client.registration.facebook.client-id= <YOUR FACEBOOK CLIENT ID>
spring.security.oauth2.client.registration.facebook.client-secret=<YOUR FACEBOOK CLIENT SECRET>
```
### Endpoints 🎯
- _GET/userVisit: Devuelve la inormacion obtenida del usuiario que inició sesion_

- _GET/userList: Devuelve la lista de usuarios que iniciaron sesion la web_


### Vista Previa ✔️

![](https://raw.githubusercontent.com/agustin-kiryk/Social-Login-actualizado/main/Sin%20t%C3%ADtulo.png)

## Construido con 🛠️

_Para realizar este pryecto se usaron las siguientes herramientas_

* 👉 ide : IJ idea
* 👉 lenguaje : JAVA - HTML - CSS -  JS - 
* 👉 Boostrap 5
* 👉 [Maven](https://maven.apache.org/) - Manejador de dependencias
* 👉 Spring Boot
* 👉 JPA
* 👉 Hibernate
* 👉 ORM : Dbiever
* 👉 Mysql
* 👉 Spring Security OAuth2
* 👉 Google developer console
* 👉 Facebook developer console


## Autor ✒️

* **Kiryk Agustin**

## Licencia 📄

🎁 Este proyecto no está bajo la Licencia 🎁

