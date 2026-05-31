Comparativa de Paradigmas de Programación
Programación Avanzada - Spring Boot 3.4+
Autor

Darwin  Gañan
Descripción del Proyecto

Este proyecto implementa una solución para la gestión y análisis de inventario de equipos tecnológicos utilizando Spring Boot.

El sistema procesa un conjunto de 10.000 registros de hardware y genera reportes analíticos sobre disponibilidad y valoración de equipos.

La solución fue desarrollada utilizando dos paradigmas de programación:

Paradigma Imperativo
Paradigma Funcional/Declarativo (Java Streams API)
Arquitectura Utilizada

El proyecto fue desarrollado siguiendo una arquitectura por capas:

Controller
Service
Entity
DTO
Enums
Util

Componentes principales:

HardwareController
HardwareService
AiService
HardwareEntity
DataGenerator
Funcionalidades

El sistema realiza las siguientes operaciones:

Generación de 10.000 registros de hardware.
Filtrado de equipos activos.
Filtrado de equipos comprados durante los últimos 5 años.
Agrupación por categoría.
Cálculo del valor total por categoría.
Cálculo del precio promedio por categoría.
Obtención del equipo más costoso por categoría.
Generación de resumen mediante AI Service.
Endpoints REST
Implementación Imperativa
GET /hardware/imperativo
Implementación Funcional
GET /hardware/streams
Comparación de Paradigmas
Paradigma Imperativo

Características:

Uso de ciclos for.
Uso de estructuras if.
Uso de acumuladores manuales.
Agrupación manual de información.

Ventajas:

Fácil de comprender para principiantes.
Permite controlar paso a paso la ejecución.

Desventajas:

Mayor cantidad de líneas de código.
Más propenso a errores humanos.
Menor mantenibilidad en proyectos grandes.
Paradigma Funcional (Streams API)

Características:

Uso de stream().
Uso de filter().
Uso de groupingBy().
Uso de Collectors.
Uso de Optional.
Uso de summarizingDouble().

Ventajas:

Código más compacto.
Mayor legibilidad.
Mejor mantenibilidad.
Facilita operaciones complejas sobre colecciones.

Desventajas:

Requiere mayor conocimiento del lenguaje.
Puede resultar menos intuitivo para desarrolladores principiantes.
Comparación Técnica
Criterio	Imperativo	Funcional
Líneas de código	Mayor cantidad	Menor cantidad
Legibilidad	Media	Alta
Mantenibilidad	Media	Alta
Escalabilidad	Media	Alta
Complejidad inicial	Baja	Media
Uso de recursos	Similar	Similar
Conclusiones
Ambos paradigmas permiten resolver correctamente el problema planteado.
La programación imperativa proporciona mayor control sobre el flujo de ejecución.
La programación funcional reduce considerablemente la cantidad de código necesario.
Streams API mejora la claridad y mantenibilidad de la solución.
Para aplicaciones empresariales modernas, el enfoque funcional resulta más adecuado para el procesamiento de colecciones de datos.
Tecnologías Utilizadas
Java 21
Spring Boot 3.4+
Gradle
Lombok
REST API
IntelliJ IDEA
