# Prueba Técnica SpringBoot HACK A BOSS

##### Juan Manuel Gómez Wals

## Instrucciones para su uso

1. Se debe clonar éste mismo repositorio.

2. Iniciamos nuestro SGBBDD y crear la base de datos "agencia".

3. Importamos nuestros archivos .sql a nuestra base de datos y se crearán tanto las columnas como las filas guardadas en ellos.

4. Iniciamos nuestro proyecto y verificamos que funciona correctamente.

## Ejecución

Esta API nos brinda la oportunidad de hacer un sistema de reserva de vuelos y habitaciones de hoteles.
Para poder usar nuestra API necesitaremos un Frontend gráfico o, en su defecto, un programa como Postman para hacer las peticiones.
En la carpeta raíz dejaré un archivo llamado "Agencia.postman_collection.json" que contiene las peticiones necesarias para hacer uso de la API.

## Acciones

- CRUD completo de Vuelos, Hoteles, Habitaciones, Clientes y Reservas de vuelos y  habitaciones que implementa:
  - Creación de las entidades.
  - Lectura de las entidades tanto por id de cada una como de todas las entidades.
  - Lectura de las entidades que están activas.
  - Actualización de las entidades por su id.
  - Eliminación lógica de las entidades por su id.

## Supuestos

- Suponemos que para crear habitaciones debe haberse creado anteriormente un hotel.

- Suponemos que para hacer reservas deben haberse creado anteriormente un vuelo y un cliente para reservas de vuelos o una habitación y un cliente para reservas de habitaciones.

- Suponemos que para hacer una reserva, ya sea de vuelo o de habitación, el vuelo o la habitación deben estar activos.
- 
## Aspectos a mejorar

- El endpoint de buscar habitación según un rango de fechas y una localización no funciona correctamente.

- Editar DTOs para sacar su máximo potencial y editar los servicios para.

- Al añadir una reserva de habitación o de vuelo, verificar que los datos coinciden con los de alguna habitación o vuelo ya existente para así evitar errores y reservar con más precisión.

- El endpoint de editar reservas no funciona correctamente.

- Implementar la seguridad de forma que permita acceder a la modificación, creación y eliminación de entidades solo a los usuarios con el rol de administrador.

## Tecnologías usadas

> Lenguaje -> Java (17)

> Framework -> SpringBoot

> Persistencia -> Hibernate

> IDE -> IntelliJ

> Base de datos -> MySQL

> Seguridad -> Spring Security