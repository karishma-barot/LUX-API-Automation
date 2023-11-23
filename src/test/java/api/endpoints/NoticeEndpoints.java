package api.endpoints;

import api.payload.Notice;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class NoticeEndpoints {

    public static Response createNotice(Notice payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_notice);
        return response;
    }
    public static Response updateNotice(int noticeId,Notice payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("notice_id",noticeId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_notice);
        return response;
    }

    public static Response getNotice(int noticeId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("notice_id",noticeId)
                .log().all()
                .when()
                .get(Routes.get_notice);
        return response;
    }

    public static Response listNotices(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_notices);
        return response;
    }

    public static Response deleteNotice(int noticeId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("notice_id",noticeId)
                .log().all()
                .when()
                .delete(Routes.delete_notice);
        return response;
    }
}
