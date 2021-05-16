package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;

public class TestSteps {

    private String path;
    private Response response;


   @When("User attempts to check the health of deployed microservice")
    public void healthCheck() {
        RestAssured.baseURI = "http://3.12.246.65:8080/healthcheck";
        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get()
                .then().extract().response();
    }

    
    @Then("a valid response from the service is recieved")
    public void validateAppResponse() {
        Assertions.assertEquals(200, response.getStatusCode());
    }

   
}
