package test;

import api.endpoints.RetailerEndpoints;
import api.payload.Retailer;
import api.utilities.ResponseData;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RetailerTestCases {

    Retailer retailerPayload;
    Faker faker;

    @BeforeClass
    public void dataSetup(){
        retailerPayload = new Retailer();
        faker = new Faker();
        retailerPayload.setCategory_ids(new int[]{2244});
        retailerPayload.setCountry("us");
        retailerPayload.setName(faker.name().firstName());
        retailerPayload.setRetailer_code(faker.regexify("[a-z0-9]"));
    }
   @Test(priority = 1)
    public void testCreateRetailer(){

        Response response = RetailerEndpoints.createRetailer(retailerPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.retailer_code = response.jsonPath().get("data.retailer_code");
        ResponseData.setRetailer_id(response.jsonPath().get("data.retailer_id"));
    }

    @Test(priority = 2)
    public void testUpdateRetailer(){
        retailerPayload.setName(faker.name().firstName());
        Response response = RetailerEndpoints.updateRetailer(this.retailerPayload.getRetailer_code(),retailerPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

    @Test(priority = 3)
    public void testGetRetailer(){
        Response response = RetailerEndpoints.getRetailer(this.retailerPayload.getRetailer_code());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }

   @Test(priority = 4)
    public void testListRetailers(){
       Response response = RetailerEndpoints.listRetailers();
       response.then().log().all();

       Assert.assertEquals(response.getStatusCode(),200);
       Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
   }
}
