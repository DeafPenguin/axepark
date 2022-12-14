package one.digitalinnovation.axepark.controller;

import io.restassured.RestAssured;
import one.digitalinnovation.axepark.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .auth()
                .basic("user", "5432")
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

//    @Test
//    // TODO Teste quebrando por motivos de migração do SpringFox para o OpenAPI, encontrar maneira de adaptar o SecurityContext e SecuritySchema
//    void whenCreateThenCheckIsCreated() {
//
//        var createDTO = new ParkingCreateDTO();
//        createDTO.setColor("Marrom");
//        createDTO.setLicense("PVI-1003");
//        createDTO.setModel("Duster");
//        createDTO.setState("GO");
//
//        RestAssured.given()
//                .auth()
//                .basic("user", "5432")
//                .when()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(createDTO)
//                .post("/parking")
//                .then()
//                .statusCode(HttpStatus.CREATED.value())
//                .body("license", Matchers.equalTo("PVI-1003"),
//                        "color", Matchers.equalTo("Marrom"),
//                        "model", Matchers.equalTo("Duster"),
//                        "state", Matchers.equalTo("GO")
//                );
//    }
}