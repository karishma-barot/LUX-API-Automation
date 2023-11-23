package api.endpoints;

import api.payload.Schedule;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class ScheduleEndpoints {

    public static Response createSchedule(Schedule payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_schedule);
        return response;
    }

    public static Response updateSchedule(int scheduleId, Schedule payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("schedule_id",scheduleId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_schedule);
        return response;
    }

    public static Response getSchedule(int scheduleId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("schedule_id",scheduleId)
                .log().all()
                .when()
                .get(Routes.get_schedule);
        return response;
    }

    public static Response listSchedules(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_schedules);
        return response;
    }

    public static Response deleteSchedule(int scheduleId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("schedule_id",scheduleId)
                .log().all()
                .when()
                .delete(Routes.delete_schedule);
        return response;
    }
}
