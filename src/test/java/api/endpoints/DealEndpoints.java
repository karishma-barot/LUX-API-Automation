package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class DealEndpoints {

    public static Response createDeal(String payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key", Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_deal);
        return response;
    }

    public static Response updateDeal(int dealId, String payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("deal_id",dealId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_deal);
        return response;
    }
    public static Response getDeal(int dealId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("deal_id",dealId)
                .log().all()
                .when()
                .get(Routes.get_deal);
        return response;
    }

    public static Response listDeals(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_deals);
        return response;
    }

    public static Response deleteDeal(int dealId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("deal_id",dealId)
                .log().all()
                .when()
                .delete(Routes.delete_deal);
        return response;
    }
}
