package test;

import api.endpoints.CentreDirectoryServiceEndpoints;
import api.payload.CentreDirectoryService;
import api.utilities.ResponseData;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CentreDirectoryServiceTestCases {
    CentreDirectoryService servicepayload;
    Faker faker;

    @BeforeClass
    public void dataSetup(){
        servicepayload = new CentreDirectoryService();
        faker = new Faker();
        servicepayload.setCentre_id("montgomery");
        servicepayload.setCountry("us");
        servicepayload.setDescription(faker.address().streetAddress());
        servicepayload.setLong_title(faker.name().title());
        servicepayload.setShort_title(faker.name().title());
        servicepayload.setService_type("Family services");
    }

    @Test(priority = 1)
    public void testCreateService(){
        Response response = CentreDirectoryServiceEndpoints.createService(servicepayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setService_id(response.jsonPath().get("data.service_id"));
    }
    @Test(priority = 2)
    public void testUpdateService(){
        String requestBody = "{\n" +
                "    \"name\": \"new name\"\n" +
                "}";
        Response response = CentreDirectoryServiceEndpoints.updateService(ResponseData.getService_id(),requestBody);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
    @Test(priority = 3)
    public void testGetService(){
        Response response = CentreDirectoryServiceEndpoints.getService(ResponseData.getService_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testListServices(){
        Response response = CentreDirectoryServiceEndpoints.listServices("montgomery");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteService(){
        Response response = CentreDirectoryServiceEndpoints.deleteService(ResponseData.getService_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
