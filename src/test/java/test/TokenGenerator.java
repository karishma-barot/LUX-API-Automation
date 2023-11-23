package test;

import api.endpoints.Routes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;



public class TokenGenerator {
    public static String token;

    @Test
    public void getToken(){
        String url = "https://qa.secure.westfieldlux.net/v1/staff/token";
        RequestSpecification http_req = RestAssured.given()
                .queryParam("api_key", Routes.apiKeySecure)
                .queryParam("grant_type","password")
                .queryParam("username",Routes.username)
                .queryParam("password",Routes.password)
                .queryParam("client_id",Routes.client_id)
                .queryParam("client_secret",Routes.client_secret)
                .header("Content-Type","application/x-www-form-urlencoded");
        Response response = http_req.post(url);
        int status_code = response.getStatusCode();
        String response_body = response.asString();
        System.out.println("Response is: "+ response_body);
        System.out.println("status code:"+status_code);
        token = response.jsonPath().get("access_token");
        System.out.println("Token is: "+token);
    }

}
