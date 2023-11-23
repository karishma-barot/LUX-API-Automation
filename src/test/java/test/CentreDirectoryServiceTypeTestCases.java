package test;

import api.endpoints.CentreDirectoryServiceTypeEndpoints;
import api.payload.CentreDirectoryServiceType;
import api.utilities.ResponseData;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CentreDirectoryServiceTypeTestCases {

    CentreDirectoryServiceType serviceTypePayload;
    Faker faker;

    @BeforeClass
    public void dataSetup(){
        serviceTypePayload = new CentreDirectoryServiceType();
        faker = new Faker();
        serviceTypePayload.setCountry("us");
        serviceTypePayload.setName(faker.name().firstName());
        serviceTypePayload.setService_class("digital");

    }
    @Test(priority = 1)
    public void testCreateServiceType(){
        Response response = CentreDirectoryServiceTypeEndpoints.createServiceType(serviceTypePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setService_type_id(response.jsonPath().get("data.service_type_id"));
    }
    @Test(priority = 2)
    public void testUpdateServiceType(){
        serviceTypePayload.setName(faker.name().firstName());
        Response response = CentreDirectoryServiceTypeEndpoints.updateServiceType(ResponseData.getService_type_id(),serviceTypePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
    @Test(priority = 3)
    public void testGetServiceType(){
        Response response = CentreDirectoryServiceTypeEndpoints.getServiceType(ResponseData.getService_type_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testListServicesTypes(){
        Response response = CentreDirectoryServiceTypeEndpoints.listServicesTypes();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteServiceType(){
        Response response = CentreDirectoryServiceTypeEndpoints.deleteServiceType(ResponseData.getService_type_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
