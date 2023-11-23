package api.endpoints;
import api.payload.Centre;
import test.TokenGenerator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class CentreEndpoints {
    public static Response createCentre(Centre payload){

    Response response= given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Authorization", "Bearer " + TokenGenerator.token)
            .queryParam("api_key",Routes.api_key)
            .body(payload)
            .log().all()
            .when()
            .post(Routes.post_centre);
    return response;
    }

    public static Response updateCentre(String centreId,Centre payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("centre_id",centreId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_centre);
        return response;
    }

    public static Response getCentre(String centreId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("centre_id",centreId)
                .log().all()
                .when()
                .get(Routes.get_centre);
        return response;
    }

    public static Response listCentres(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_centres);
        return response;
    }
}
