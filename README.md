# Foro Hub API

## Descripción del proyecto

**Foro Hub** es una API REST desarrollada con **Java y Spring Boot** que simula el funcionamiento de un foro académico.
En este sistema, los estudiantes pueden crear tópicos con dudas sobre diferentes temas y los profesores o moderadores pueden responderlas actualizando el tópico.

El objetivo del proyecto es practicar el desarrollo de **APIs RESTful**, implementando operaciones **CRUD**, autenticación con **JWT**, y persistencia de datos con **MySQL**.

---

## Funcionalidades

La API permite realizar las siguientes operaciones:

### Usuarios

* Registrar usuarios en el sistema asignando un cargo (estudiante, profesor, moderador)
* Almacenar información personal del usuario
* Asociar dirección al usuario


### Autenticación

* Login de usuarios
* Generación de **token JWT**
* Validación del token en cada petición
* Protección de rutas mediante **Spring Security**

### Tópicos

* Crear un nuevo tópico
* Listar todos los tópicos
* Consultar un tópico específico
* Actualizar un tópico
* Desactivar(eliminar) un tópico

---

## Tecnologías utilizadas

* **Java 25**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Hibernate / JPA**
* **MySQL**
* **Lombok**
* **Maven**
* **IntelliJ IDEA**
* **Insomnia** para pruebas de API

---

## Estructura del proyecto

El proyecto está organizado en diferentes capas siguiendo buenas prácticas de desarrollo:

```
src/main/java/com/alura/foro_hub

controller
│   ├── autenticacioncontroller
│   ├── registrocontroller
│   ├── topicocontroller
│   └── usuariocontroller
│ 
│
├── domain
│   ├── topico
│   ├── usuario
│   ├── direccion
│   └── registro
│   └── direccion
│ 
│
├── infra
│   └── exceptions
│   └── secuirity
│        ├── SecurityFilter
│        └── TokenService
│
---

## Base de datos

La aplicación utiliza **MySQL** como sistema de gestión de base de datos.

Tablas principales:

### usuarios

Contiene la información de los usuarios registrados.

Campos principales:

* id
* nombre
* email
* telefono
* documento
* cargo
* direccion
* activo

### registro

Tabla utilizada para el **inicio de sesión de usuarios**.

Campos principales:

* id
* login
* password

### topicos

Almacena los tópicos creados por los estudiantes.

Campos principales:

* id
* titulo
* mensaje
* fecha_creacion
* estado
* autor

---

## Seguridad

El proyecto implementa autenticación basada en **JWT (JSON Web Token)**.

Flujo de autenticación:

1. El usuario envía sus credenciales al endpoint `/login`.
2. Si las credenciales son correctas, el servidor genera un **token JWT**.
3. El cliente debe enviar el token en cada petición protegida mediante el header:

```
Authorization: Bearer TOKEN
```

4. El **SecurityFilter** valida el token antes de permitir el acceso a los endpoints protegidos.

---

## Endpoints principales

### Autenticación

POST `/login`

Permite iniciar sesión y obtener un token JWT.

---

### Usuarios

POST `/usuarios`

Registrar un nuevo usuario.

---

### Tópicos

POST `/topicos`
Crear un nuevo tópico.

GET `/topicos`
Listar todos los tópicos.

GET `/topicos/{id}`
Consultar un tópico específico.

PUT `/topicos/{id}`
Actualizar un tópico (respuesta del profesor o moderador).

DELETE `/topicos/{id}`

Colocar inactivo un tópico específico.
