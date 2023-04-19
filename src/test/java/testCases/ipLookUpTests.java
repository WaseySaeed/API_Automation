package testCases;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static config.configProperties.*;
import static io.restassured.RestAssured.*;
import static util.utilityFunction.*;

import io.restassured.http.ContentType;
import util.extentReport;

import java.util.HashMap;

public class ipLookUpTests {

    @Test
    public void validateIpv4Request() {

        HashMap<String, Object> queryParams = new HashMap<>();
        HashMap<String, String> headers = getAuthenticationHeaders();

        queryParams.put("q", "202.47.63.178");

        Response response = given().headers(headers).queryParams(queryParams).contentType(ContentType.JSON)
                .when().request("GET", baseUrl)
                .then().statusCode(200)
                .extract().response();

        extentReport.logInfo(response.getBody().prettyPrint());

    }

    @Test
    public void validateIpv6Request() {

        HashMap<String, Object> queryParams = new HashMap<>();
        HashMap<String, String> headers = getAuthenticationHeaders();

        queryParams.put("q", "2400:adc1:49d:bb00:e0d8:8605:36f3:d95e");

        Response response = given().headers(headers).queryParams(queryParams).contentType(ContentType.JSON)
                .when().request("GET", baseUrl)
                .then().statusCode(200)
                .extract().response();

        extentReport.logInfo(response.getBody().prettyPrint());
    }

    @Test
    public void sendIncorrectIPNoLocationFound()
    {
        HashMap<String, Object> queryParams = new HashMap<>();
        HashMap<String, String> headers = getAuthenticationHeaders();
        queryParams.put("q", "2001:4860:4860:8888");

        Response response = given().headers(headers).queryParams(queryParams).contentType(ContentType.JSON)
                .when().request("GET", baseUrl)
                .then().statusCode(400)
                .extract().response();

        extentReport.logInfo(response.getBody().prettyPrint());
    }
}
