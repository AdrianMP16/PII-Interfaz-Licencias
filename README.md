Sistema de Gestión de Licencias de Conducir - Módulo Administrador
Proyecto de escritorio en Java + Swing + MySQL para la gestión administrativa del proceso de obtención y emisión de licencias de conducir.
Características principales

Registro de nuevos solicitantes (con tipo de licencia)
Verificación de requisitos (certificado médico, pago, multas)
Registro de notas de exámenes teórico y práctico
Cálculo automático de promedio y cambio de estado (Aprobado / Rechazado)
Generación de licencias (fecha emisión + vencimiento a 5 años)
Gestión completa de usuarios del sistema (crear, editar, activar/desactivar)
Reportes y estadísticas básicas
Exportación de tablas a Excel (usando Apache POI)

Tecnologías utilizadas

Java 8+ (preferiblemente 11 o 17)
Swing (interfaz gráfica)
MySQL / MariaDB
JDBC
Apache POI (exportación a Excel .xlsx)
Patrón MVC básico (separación Modelo-Vista-Controlador muy ligera)

Requisitos previos

Java JDK 11 o superior instalado
java -version debe mostrar al menos 11
MySQL 5.7+ o MariaDB 10.2+
Recomendado: MariaDB 10.6+
Maven (opcional, pero muy recomendado para manejar dependencias)O bien agregar manualmente los siguientes .jar al proyecto:
mysql-connector-java-8.x.x.jar (o 9.x si usas MySQL 8+)
poi-5.2.5.jar
poi-ooxml-5.2.5.jar
poi-ooxml-schemas-4.1.2.jar (o versiones compatibles)
xmlbeans-5.2.0.jar
commons-collections4-4.4.jar


Estructura del proyecto
licencias-conducir/
├─ src/
│   ├─ Modelo/
│   │   └─ AdminWindow.java
│   │   └─ ConexionBD.java
│   ├─ Controlador/
│   │   └─ Login.java   (se asume que existe)
│   ├─ Vista/
│   │   └─ (formularios .form si usas IntelliJ GUI Designer)
│   └─ resources/
│       └─ application.properties  (opcional)
├─ lib/                        ← jars externos aquí si no usas Maven
├─ sql/                        ← scripts de base de datos
   └─ 01_create_database.sql
   └─ 02_inserts_iniciales.sql

-----------------------------------
Credenciales de acceso:
Administrador:
User: Admin
Contraseña: 1234

Analista:
User: Analista1
Contraseña: 4321
