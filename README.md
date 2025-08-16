# 🎫 Sistema de Gestión de Tickets de Soporte Técnico

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Descripción

Sistema b{asico de gestión de tickets de soporte técnico desarrollado en **Spring Boot 3.5.4** con **Java 21**. Esta aplicación permite a los equipos de soporte técnico crear, gestionar y dar seguimiento a los tickets de soporte de manera eficiente.

## ✨ Características Principales

- 🆕 **Creación de Tickets**: Crear tickets con título, descripción y prioridad
- 📊 **Gestión de Estados**: Control del ciclo de vida del ticket (Abierto → En Proceso → Cerrado)
- 🚨 **Sistema de Prioridades**: Clasificación por prioridad (Alta, Media, Baja)
- 🔍 **Filtros Avanzados**: Consulta de tickets por estado
- ⏰ **Seguimiento Temporal**: Registro automático de fechas de creación y cierre


## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas siguiendo los principios de **Clean Architecture**:

```
src/main/java/com/alonsocode/gestiontickets/
├── 📁 controller/          # Capa de presentación (REST API)
├── 📁 service/             # Capa de lógica de negocio
├── 📁 repository/          # Capa de acceso a datos
└── 📁 model/               # Entidades y modelos de dominio
    └── 📁 entity/
        ├── 📁 enums/       # Enumeraciones del dominio
        └── Ticket.java     # Entidad principal
```

## 🚀 Tecnologías Utilizadas

- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5.4** - Framework de aplicación
- **Spring Web** - Para la creación de APIs REST
- **Spring DevTools** - Herramientas de desarrollo
- **Maven** - Gestión de dependencias y build

## 📦 Requisitos Previos

- **Java 21** o superior
- **Maven 3.9** o superior
- **IDE compatible** (IntelliJ IDEA, Eclipse, VS Code)

## 🛠️ Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/uavargas/Sistema-de-Gestion-de-Tickets-de-Soporte-Tecnico.git
cd gestionTickets
```

### 2. Verificar Java

```bash
java -version
# Debe mostrar Java 21 o superior
```

### 3. Verificar Maven

```bash
mvn -version
# Debe mostrar Maven 3.9 o superior
```

### 4. Compilar el Proyecto

```bash
mvn clean compile
```

### 5. Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: **http://localhost:8080**

## 📚 API REST - Endpoints Disponibles

### 🆕 Gestión de Tickets

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/ticket` | Crear un nuevo ticket |
| `GET` | `/ticket` | Obtener todos los tickets |
| `GET` | `/ticket/{id}` | Obtener ticket por ID |
| `PUT` | `/ticket/{id}/estado?estado={estado}` | Actualizar estado del ticket |
| `DELETE` | `/ticket/{id}` | Eliminar ticket |

### 🔍 Filtros por Estado

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/ticket/ticketsAbiertos` | Obtener tickets abiertos |
| `GET` | `/ticket/ticketsEnProceso` | Obtener tickets en proceso |
| `GET` | `/ticket/ticketsCerrados` | Obtener tickets cerrados |

## 📊 Modelo de Datos

### 🎫 Entidad Ticket

```java
public class Ticket {
    private Long id;                    // Identificador único
    private String titulo;              // Título del ticket
    private String descripcion;         // Descripción detallada
    private PrioridadTicket prioridad;  // Prioridad (ALTA, MEDIA, BAJA)
    private EstadoTicket estado;        // Estado (ABIERTO, EN_PROCESO, CERRADO)
    private LocalDateTime fechaCreacion; // Fecha de creación automática
    private LocalDateTime fechaCierre;   // Fecha de cierre (cuando se cierra)
}
```

### 🏷️ Enumeraciones

#### PrioridadTicket
- `ALTA` - Requiere atención inmediata
- `MEDIA` - Atención en las próximas horas
- `BAJA` - Atención en las próximas 24-48 horas

#### EstadoTicket
- `ABIERTO` - Ticket recién creado
- `EN_PROCESO` - Ticket siendo atendido
- `CERRADO` - Ticket resuelto

## 🔄 Flujo de Trabajo del Ticket

```
1. CREACIÓN → Ticket se crea con estado ABIERTO
2. ASIGNACIÓN → Ticket cambia a EN_PROCESO
3. RESOLUCIÓN → Ticket cambia a CERRADO
```

### 📋 Reglas de Negocio

- ✅ Un ticket **ABIERTO** puede cambiar a **EN_PROCESO**
- ✅ Un ticket **EN_PROCESO** puede cambiar a **CERRADO**
- ❌ Un ticket **ABIERTO** NO puede cambiar directamente a **CERRADO**
- ❌ Un ticket **CERRADO** NO puede ser modificado

## 📝 Ejemplos de Uso

### 1. Crear un Nuevo Ticket

```bash
curl -X POST http://localhost:8080/ticket \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Problema con acceso al sistema",
    "descripcion": "Usuario no puede acceder a la plataforma web",
    "prioridad": "ALTA"
  }'
```

### 2. Obtener Todos los Tickets

```bash
curl -X GET http://localhost:8080/ticket
```

### 3. Cambiar Estado del Ticket

```bash
curl -X PUT "http://localhost:8080/ticket/1/estado?estado=EN_PROCESO"
```

### 4. Obtener Tickets Abiertos

```bash
curl -X GET http://localhost:8080/ticket/ticketsAbiertos
```



### Personalización del Banner

El proyecto incluye un banner personalizado en `src/main/resources/banner.txt` que se muestra al iniciar la aplicación.

## 📁 Estructura del Proyecto

```
gestionTickets/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   └── 📁 com/alonsocode/gestiontickets/
│   │   │       ├── 📁 controller/
│   │   │       │   └── TicketController.java
│   │   │       ├── 📁 service/
│   │   │       │   ├── ITicketService.java
│   │   │       │   └── TicketServiceImpl.java
│   │   │       ├── 📁 repository/
│   │   │       │   └── TicketRepository.java
│   │   │       ├── 📁 model/
│   │   │       │   └── 📁 entity/
│   │   │       │       ├── 📁 enums/
│   │   │       │       │   ├── EstadoTicket.java
│   │   │       │       │   └── PrioridadTicket.java
│   │   │       │       └── Ticket.java
│   │   │       └── GestionTicketsApplication.java
│   │   └── 📁 resources/
│   │       ├── application.properties
│   │       ├── banner.txt
│   │       ├── 📁 static/
│   │       └── 📁 templates/
│   └── 📁 test/
│       └── 📁 java/
│           └── 📁 com/alonsocode/gestiontickets/
│               └── GestionTicketsApplicationTests.java
├── 📁 target/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
├── .gitattributes
└── README.md
```



## 👨‍💻 Autor

**AlonsoCode** - [GitHub](https://github.com/uvargas)

---

**¡Gracias por su retroalimentación al Sistema de Gestión de Tickets! 🎉** 
