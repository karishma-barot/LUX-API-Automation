package api.endpoints;

import api.endpoints.Routes;
import api.payload.CentreDirectoryService;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class CentreDirectoryServiceEndpoints {
    public static Response createService(CentreDirectoryService payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key", Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_service);
        return response;
    }

    public static Response updateService(int serviceId, String payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("service_id",serviceId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_service);
        return response;
    }
    public static Response getService(int serviceId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("service_id",serviceId)
                .log().all()
                .when()
                .get(Routes.get_service);
        return response;
    }

    public static Response listServices(String centreId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("centre_id",centreId)
                .log().all()
                .when()
                .get(Routes.list_services);
        return response;

    }

    public static Response deleteService(int serviceId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("service_id",serviceId)
                .log().all()
                .when()
                .delete(Routes.delete_service);
        return response;
    }
}
