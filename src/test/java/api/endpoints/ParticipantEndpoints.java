package api.endpoints;

import api.payload.Participant;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class ParticipantEndpoints {

    public static Response createParticipant(Participant payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_participant);
        return response;
    }

    public static Response updateParticipant(int participantId, Participant payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("participant_id",participantId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_participant);
        return response;
    }

    public static Response getParticipant(int participantId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("participant_id",participantId)
                .log().all()
                .when()
                .get(Routes.get_participant);
        return response;
    }

    public static Response listParticipants(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_participants);
        return response;
    }

    public static Response deleteParticipant(int participantId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("participant_id",participantId)
                .log().all()
                .when()
                .delete(Routes.delete_participant);
        return response;
    }
}
