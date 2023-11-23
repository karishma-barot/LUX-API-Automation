package api.endpoints;

import api.payload.Category;
import api.payload.Centre;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.TokenGenerator;

import static io.restassured.RestAssured.given;

public class CategoryEndpoints {
    public static Response createCategory(Category payload){

        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .body(payload)
                .log().all()
                .when()
                .post(Routes.post_category);
        return response;
    }
    public static Response updateCategory(int categoryId,Category payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("category_id",categoryId)
                .body(payload)
                .log().all()
                .when()
                .patch(Routes.patch_category);
        return response;
    }

    public static Response getCategory(int categoryId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("category_id",categoryId)
                .log().all()
                .when()
                .get(Routes.get_category);
        return response;
    }

    public static Response listCategories(){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .log().all()
                .when()
                .get(Routes.list_categories);
        return response;
    }

    public static Response deleteCategory(int categoryId){
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenGenerator.token)
                .queryParam("api_key",Routes.api_key)
                .pathParam("category_id",categoryId)
                .log().all()
                .when()
                .delete(Routes.delete_category);
        return response;
    }
}
