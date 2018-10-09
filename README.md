# Arquitectura de un mini API-Rest simulado
> Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código
> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

[![Build Status](https://travis-ci.org/jzea/APAW-ECP2-Jesus.Zea.svg?branch=master)](https://travis-ci.org/jzea/APAW-ECP2-Jesus.Zea)

## Tecnologías necesarias
* Java
* Maven
* GitHub

## Diseño de entidades
![themes-entities-class-diagram](https://github.com/jzea/APAW-ECP2-Jesus.Zea/blob/master/src/docs/diagrama.JPG)

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