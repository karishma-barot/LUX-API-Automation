package api.endpoints;

import api.payload.CentreDirectoryService;
import api.payload.CentreDirectoryServiceType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class CentreDirectoryServiceTypeEndpoints {
    public static Response createServiceType(CentreDirectoryServiceType payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key", Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_service_type);
        return response;
    }

    public static Response updateServiceType(int serviceTypeId, CentreDirectoryServiceType payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("service_type_id",serviceTypeId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_service_type);
        return response;
    }
    public static Response getServiceType(int serviceTypeId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("service_type_id",serviceTypeId)
                .log().all()
                .when()
                .get(Routes.get_service_type);
        return response;
    }

    public static Response listServicesTypes(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_services_types);
        return response;

    }

    public static Response deleteServiceType(int serviceTypeId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("service_type_id",serviceTypeId)
                .log().all()
                .when()
                .delete(Routes.delete_service_type);
        return response;
    }
}
