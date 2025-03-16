Kata-Apis - Automatización de Pruebas de API 🚀

Repositorio para la automatización de pruebas de API utilizando Serenity BDD , RestAssured , JUnit 5 y Gradle .

📌 Prerrequisitos

Para la ejecucion de este proyecto es necesario contar con las siguientes herramientas instaladas:

* [Gradle](https://gradle.org/)
* [Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Git](http://git-scm.com/)

Además, en el IDE de preferencia se deben instalar los siguientes plugins:

1. [x] **JUnit**
2. [x] **Cucumber for Java**
3. [x] **Gherkin**
4. [x] **Lombok**

## 🛠️ Tecnologías utilizadas
 
El proyecto está desarrollado con las siguientes tecnologías:

* [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html)- Marco de pruebas
* [JUnit 5](https://junit.org/junit5/)- Marco de pruebas unitarias
* [Rest Assured](https://rest-assured.io/)- Cliente HTTP para pruebas de API
* [Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Gradle](https://gradle.org/) Sistema de construcción y gestión de dependencias

## 📂 Estructura del proyecto
El proyecto sigue una estructura estándar para pruebas en Serenity BDD:
```plaintext
src             
  ├── main                                  # Código principal (si aplica)
  ├── test                                  # Código de pruebas
  │   ├── java
  │   │   └── org.bdb.kata.api.tests        # Paquete base de pruebas
  │   │       ├── GetApiTest.java           # Pruebas para GET
  │   │       ├── PostApiTest.java          # Pruebas para POST
  │   │       ├── PutApiTest.java           # Pruebas para PUT
  │   │       ├── DeleteApiTest.java        # Pruebas para DELETE
  │   ├── resources
  │   │   ├── data                          # Archivos JSON para los cuerpos de las peticiones
  │   │   │   ├── newProduct.json
  │   │   │   ├── updateProduct.json
  │   │   ├── junit-platform.properties     # Configuración de JUnit
  ├── build.gradle                          # Archivo de configuración de Gradle
  ├── serenity.properties                   # Configuración de Serenity
  ├── settings.gradle                       # Configuración del proyecto Gradle
```

🚀 Ejecución del Proyecto
1️⃣ Ejecutar pruebas de API
Para ejecutar:
```bash
./gradlew clean test
```
📌 Generar informe de Serenity
Una vez finalizada
📂 El informe estará disponible en: target/site/serenity/index.html

Ejecución en paralelo
Las pruebas están configuradas para ejecutarse en paralelo. JUnit 5 maneja la ejecución simultánea a través de la siguiente configuración en junit-platform.properties:
junit.jupiter.execution.parallel.enabled = true
junit.jupiter.execution.parallel.mode.default = concurrent
junit.jupiter.execution.parallel.mode.classes.default = concurrent
Esto permite ejecutar hasta 3 pruebas simultáneamente para mejorar la eficiencia.

📌 Validaciones incluidas
Las pruebas de API incluyen las siguientes validaciones:

✅ Consumo exitoso de API (código 200, 201)
✅ Consumo con error (código 400, 404, 500 según la API)
✅ Lectura del cuerpo desde archivos JSON
✅ Validación del código de respuesta
✅ Impresión de respuestas en consola
✅ Generación de reportes de pruebas
✅ Ejecución en paralelo de 3 pruebas simultáneas