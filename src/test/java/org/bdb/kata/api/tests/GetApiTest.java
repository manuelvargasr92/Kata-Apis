package org.bdb.kata.api.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.File;

import static org.hamcrest.Matchers.*;
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public class GetApiTest {

    private static final String BASE_URL = "https://fakestoreapi.com";

    /**
     * 🔹 Prueba GET - Obtener todos los productos
     */
    @Test
    public void testGetAllProductsSuccess() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath("/products")
                .header("Accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200) // Validar código de estado exitoso
                .body("size()", greaterThan(0)) // Verificar que hay productos en la respuesta
                .log().all(); // Imprimir respuesta en consola
    }
    /**
     * 🔹 Prueba GET - Validar respuesta en caso de endpoint incorrecto
     */
    @Test
    public void testGetInvalidEndpoint() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath("/invalid-endpoint")
                .header("Accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(404) // Validar código de estado incorrecto
                .log().all();
    }


}
