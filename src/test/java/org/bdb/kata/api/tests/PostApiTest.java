package org.bdb.kata.api.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.hamcrest.Matchers.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Execution(ExecutionMode.CONCURRENT)
public class PostApiTest {

    private static final String BASE_URL = "https://fakestoreapi.com";
    private static int createdProductId; // Variable para almacenar el ID del producto creado

    @Test
      public void testCreateProduct() throws IOException {
        // Ruta correcta del archivo JSON
        String jsonFilePath = "src/test/resources/data/newProduct.json";
        File jsonData = new File(jsonFilePath);

        // Verificar que el archivo existe y no está vacío
        Assertions.assertTrue(jsonData.exists(), " El archivo JSON no existe en la ruta: " + jsonFilePath);
        Assertions.assertTrue(jsonData.length() > 0, " El archivo JSON está vacío.");

        // Leer el contenido del JSON
        String jsonBody = new String(Files.readAllBytes(jsonData.toPath()));

        // 🔍 Imprimir el JSON antes de enviarlo para depuración
        System.out.println("Ruta del archivo JSON: " + jsonData.getAbsolutePath());
        System.out.println("Contenido del archivo JSON:\n" + jsonBody);

        // Enviar la petición POST
        Response response = SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath("/products")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonBody) // Enviar el JSON como String
                .log().all() // Log de la petición para depuración
                .when()
                .post()
                .then()
                .statusCode(200) // Validar código de respuesta
                .body("id", notNullValue())
                .log().all() // Log de la respuesta
                .extract().response();

        // 🔹 Verificar el ID recibido en la respuesta
        System.out.println("🔹 ID recibido en respuesta: " + response.path("id"));

        // Extraer el ID del producto creado
        createdProductId = response.path("id");

        // Validación extra para asegurar que se obtuvo un ID válido
        Assertions.assertTrue(createdProductId > 0, "No se pudo extraer un ID válido del producto.");
        System.out.println("Producto creado con ID: " + createdProductId);
    }
}
