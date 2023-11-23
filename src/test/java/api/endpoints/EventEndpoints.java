package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class EventEndpoints {
    public static Response creatEvent(String payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key", Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_event);
        return response;
    }

    public static Response updateEvent(int eventId, String payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("event_id",eventId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_event);
        return response;
    }
    public static Response getEvent(int eventId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("event_id",eventId)
                .log().all()
                .when()
                .get(Routes.get_event);
        return response;
    }

    public static Response listEvents(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_events);
        return response;
    }

    public static Response deleteEvent(int eventId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("event_id",eventId)
                .log().all()
                .when()
                .delete(Routes.delete_event);
        return response;
    }
}
