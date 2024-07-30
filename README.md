# Kata: Conversor de Números Romanos

Esta Kata consiste en un componente desarrollado en **Spring Boot** que permite convertir números arábicos a romanos y viceversa. 

## Ejemplo de Conversión
**Conversión de Números Arábicos a Romanos**

* 1 -> I
* 2 -> II
* 9 -> IX
* 50 -> L

**Conversión de Números Romanos a Arábicos.**

* V -> 5
* XXI -> 21
* C -> 100
* M -> 1000

## Funcionalidad General
Permite realizar las siguienes operaciones:

* Convertir números romanos a arábicos.
* Convertir números arábicos a romanos.
---

## Levantar la Aplicación

### 1 - Docker
**Requisito:** Tener instalado `docker` y `docker-compose`

Para levantar la aplicación ejecutamos:


```bash
docker-compose up -d
```

### 2 - Sin Docker

- Compilar el proyecto

```bash
  mvn clean install
```

- Ejecutar la aplicación  

```bash
 mvn spring-boot:run
``` 

-------

## Probar aplicación
### - Utilizando Curl
- **Convertir de arábico a romano**

```bash
 curl --location 'localhost:8080/api/to-roman?number=22'
``` 
**Respuesta esperada:** XXII
  

- **Convertir de romano a arábico**

```bash
curl --location 'localhost:8080/api/to-arabic?roman=XX'
``` 
**Respuesta esperada:** 20


### - Utilizando Browser
- **Convertir de arábico a romano**
    - localhost:8080/api/to-roman?number=22


- **Convertir de romano a aŕabico**
    - localhost:8080/api/to-arabic?roman=XX


