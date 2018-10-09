# Arquitectura de un mini API-Rest simulado
> Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código
> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

[! [Estado de compilación] (https://travis-ci.org/jzea/APAW-ECP2-Jesus.Zea.svg?branch=master)] (https://travis-ci.org/jzea/APAW-ECP2 -Jesus.Zea)

## Tecnologías necesarias
* Java
* Maven
* GitHub

## Diseño de entidades
! [themes-architecture-diagram] (https://github.com/jzea/APAW-ECP2-Jesus.Zea/blob/master/src/docs/diagrama.JPG)

## Arquitectura
! [temas-entidades-clase-diagrama] (https://github.com/miw-upm/APAW-themes-layers/blob/develop/docs/themes-architecture-diagram.png)

### Responsabilidades
#### Despachador
* Centraliza las peticiones y hace de repartidor
* Recupera los datos de la petición y los pasa como parámetros de método
* Captura las excepciones y las convierte en errores Http
#### restControllers
* Define el path del recurso
* Valida la entrada
* Traspasa la petición a los controladores de la capa de negocio
#### businessControllers
* Procesa la petición, apoyándose en los DAO’s
* Crea las entidades a partir de los DTO’s
* Gestiona la respuesta a partir de las entidades. Delega en los DTO’s la creación a partir de la entidad
#### daos
* Gestionan la BD
#### entidades
* Son las entidades persistentes en la BD

## API
### POST / empresas
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
- `razonSocial`: String (** required **)
#### Respuesta
- 200 ok 
  - `id`: cadena
- 403 BAD_REQUEST
---
### PATH /empresas/{id}
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
#### Respuesta
- 200 ok 
- 403 BAD_REQUEST
- 404 NO ENCONTRADO
--- 
### POST /eventos
#### Parámetros del cuerpo
- `nombre`: String (**requerido**)
- `descripcion`: String
- `estado`: Boolean
- `tipoEvento`: TipoEvento
- `empresaId`: String
#### Respuesta
- 200 ok 
  - `id`: cadena
- 403 BAD_REQUEST
- 404 NO ENCONTRADO
---
### GET /eventos
#### Respuesta
- 200 ok 
  - `[ {nombre:String,descripcion:String} ]`
---
### DELETE /eventos/{id}
#### Respuesta
- 200 ok 
---
### POST /eventos/{id}/horarios
#### Parámetros del cuerpo
- `inicio`: LocalDateTime (**requerido**)
- `fin`: LocalDateTime (**requerido**)
#### Respuesta
- 200 ok 
- 403 BAD_REQUEST
- 404 NO ENCONTRADO
---
### GET /eventos/search?q=estado:=true
#### Respuesta
- 200 ok
  - `[ {nombre:String,descripcion:String} ]`
- 403 BAD_REQUEST
---
### POST /comentarios
#### Parámetros del cuerpo
- `titulo`: String (**requerido**)
- `descripcion`: String (**requerido**) 
#### Respuesta
- 200 ok 
- 403 BAD_REQUEST
---
### PUT /comentarios/{id}
#### Parámetros del cuerpo
- `titulo`: String (**requerido**)
- `descripcion`: String (**requerido**)
#### Respuesta
- 200 ok 
- 403 BAD_REQUEST
- 404 NO ENCONTRADO
--- 