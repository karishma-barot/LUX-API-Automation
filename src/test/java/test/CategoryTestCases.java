package test;

import api.endpoints.CategoryEndpoints;
import api.payload.Category;
import api.utilities.ResponseData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryTestCases {
    Category categoryPayload;

    @Test(priority = 1)
    public void testCreateCategory(){
       categoryPayload = new Category();
       categoryPayload.setEnabled(true);
       categoryPayload.setParent_id(1);
       categoryPayload.setIcon("");
        Response response = CategoryEndpoints.createCategory(categoryPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
      ResponseData.category_id = response.jsonPath().get("data.category_id");
        System.out.println("category_id is: "+ ResponseData.category_id);
    }
    @Test(priority = 2)
    public void testPatchCategory() {

        categoryPayload.setIcon("abc.com");
        Response response = CategoryEndpoints.updateCategory(ResponseData.getCategory_id(), categoryPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 204);
    }
    @Test(priority = 3)
    public void testGetCategory(){
        Response response = CategoryEndpoints.getCategory(ResponseData.getCategory_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testListCategories(){
        Response response = CategoryEndpoints.listCategories();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeletecategory(){
        Response response = CategoryEndpoints.deleteCategory(ResponseData.getCategory_id());
        Assert.assertEquals(response.getStatusCode(),204);
    }
}
