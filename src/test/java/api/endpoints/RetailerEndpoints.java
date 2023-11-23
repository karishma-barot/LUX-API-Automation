package api.endpoints;

import api.payload.Retailer;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class RetailerEndpoints {
    public static Response createRetailer(Retailer payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_retailer);
        return response;
    }

    public static Response updateRetailer(String retailerCode,Retailer payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("retailer_code",retailerCode)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_retailer);
        return response;
    }

    public static Response getRetailer(String retailerCode){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("retailer_code",retailerCode)
                .log().all()
                .when()
                .get(Routes.get_retailer);
        return response;
    }

    public static Response listRetailers(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_retailers);
        return response;
    }
}
