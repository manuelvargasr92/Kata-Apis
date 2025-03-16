package org.bdb.kata.api.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.hamcrest.Matchers.equalTo;
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public class DeleteApiTest {
    private static final String BASE_URL = "https://fakestoreapi.com";

    /**
     * 🔹 Prueba DELETE - Simulación de eliminación de un producto
     */
    @Test
    public void testDeleteProduct() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath("/products/1") // ID del producto a "eliminar"
                .header("Accept", "application/json")
                .when()
                .delete()
                .then()
                .statusCode(200) // FakeStoreAPI siempre devuelve 200
                .body("id", equalTo(1)) // Verificar que devuelve el mismo ID
                .log().all();

        // Hacer GET después de DELETE (FakeStoreAPI no elimina realmente)
        SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath("/products/1")
                .header("Accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200) // FakeStoreAPI siempre devuelve 200 en GET
                .log().all();
    }
}
