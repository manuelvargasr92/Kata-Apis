package org.bdb.kata.api.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public class PutApiTest {
    private static final String BASE_URL = "https://fakestoreapi.com";

    @Test
    public void testUpdateProduct() {
        File jsonData = new File("src/test/resources/data/updateProduct.json");

        SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath("/products/1")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonData)
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("price.toString()", equalTo("49.99")) // 🔹 Convertir el precio a String para comparación exacta
                .body("title", equalTo("Updated Product"))
                .log().all();
    }
}
