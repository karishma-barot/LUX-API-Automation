package api.endpoints;

import api.payload.Centre;
import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {
    public static Response createStore(Store payload){

        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_store);
        return response;
    }

    public static Response updateStore(int storeId,String status){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("store_id",storeId)
                .body(status)
                .log().all()
                .when()
                .patch(Routes.patch_store);
        return response;
    }

    public static Response getStore(int storeId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("store_id",storeId)
                .log().all()
                .when()
                .get(Routes.get_store);
        return response;
    }

    public static Response listStore(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_stores);
        return response;
    }

}
