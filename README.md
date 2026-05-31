# 📊 Comparativa de Paradigmas de Programación
> **Programación Avanzada - Spring Boot 3.4+**

Este proyecto implementa una solución robusta para la gestión y análisis de inventario de equipos tecnológicos. El sistema procesa eficientemente un conjunto de **10,000 registros** de hardware, generando reportes analíticos detallados sobre la disponibilidad y valoración de los equipos.

---

## 👤 Autor
*   **Darwin Gañan**

---

## 🏗️ Arquitectura del Proyecto
Se ha implementado una arquitectura limpia por capas para asegurar la escalabilidad y mantenibilidad:

- **Controller**: Gestión de endpoints REST.
- **Service**: Lógica de negocio y procesamiento de paradigmas.
- **Entity / Model**: Definición de estructuras de datos.
- **DTO**: Transferencia de datos optimizada.
- **Enums & Utils**: Componentes de apoyo y generadores de datos.

### 🧩 Componentes Principales
- `HardwareController`
- `HardwareService`
- `AiService`
- `DataGenerator`

---

## 🚀 Funcionalidades
El sistema realiza operaciones analíticas avanzadas sobre 10,000 registros:
- [x] Filtrado dinámico de equipos activos.
- [x] Análisis de compras de los últimos 5 años.
- [x] Agrupación inteligente por categorías.
- [x] Cálculo de valor total y precio promedio por categoría.
- [x] Identificación de activos de alto valor (equipo más costoso).
- [x] Generación de resúmenes mediante integración con AI Service.

---

## 🛣️ Endpoints REST

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/hardware/imperativo` | Procesamiento utilizando lógica tradicional. |
| `GET` | `/hardware/funcional` | Procesamiento utilizando Java Streams API. |

---

## 🔍 Comparación de Paradigmas

### 🔴 Paradigma Imperativo
**Características:**
- Uso extensivo de ciclos `for` y `foreach`.
- Control manual mediante estructuras `if-else`.
- Gestión de estado mediante acumuladores y banderas.

**Pros/Contras:**
- ✅ **Ventaja:** Control total sobre el flujo paso a paso; fácil de depurar para principiantes.
- ❌ **Desventaja:** Código más extenso, propenso a errores de estado y difícil de mantener en grandes volúmenes.

### 🔵 Paradigma Funcional (Java Streams API)
**Características:**
- Uso de funciones de alto nivel: `stream()`, `filter()`, `map()`.
- Reducción y recolección mediante `Collectors` y `groupingBy()`.
- Uso de `Optional` para manejo seguro de nulos.

**Pros/Contras:**
- ✅ **Ventaja:** Código declarativo, compacto y altamente legible. Facilita el procesamiento paralelo.
- ❌ **Desventaja:** Curva de aprendizaje inicial más elevada para desarrolladores tradicionales.

---

## 📈 Tabla Comparativa Técnica

| Criterio | Paradigma Imperativo | Paradigma Funcional |
| :--- | :--- | :--- |
| **Líneas de Código** | ➕ Mayor cantidad | ➖ Menor cantidad |
| **Legibilidad** | Media | Alta (Declarativa) |
| **Mantenibilidad** | Compleja | Sencilla |
| **Escalabilidad** | Limitada | Alta (Fácil paralelismo) |
| **Complejidad Inicial** | Baja | Media |

---

## 🛠️ Tecnologías Utilizadas
*   **Lenguaje:** Java 21 ☕
*   **Framework:** Spring Boot 3.4+ 🌱
*   **Gestor de Dependencias:** Gradle 🐘
*   **Productividad:** Lombok 🌶️
*   **IDE:** IntelliJ IDEA 💎

---

## 💡 Conclusiones
1.  Ambos paradigmas resuelven el problema, pero el enfoque **funcional** reduce drásticamente la verbosidad del código.
2.  La **mantenibilidad** mejora significativamente con Streams API al expresar el "qué se hace" en lugar del "cómo se hace".
3.  Para entornos empresariales modernos con Java 21, la **programación funcional** es el estándar recomendado para el procesamiento de colecciones de datos.
