package test;

import api.endpoints.CentreEndpoints;
import api.payload.Centre;
import api.utilities.ResponseData;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class CentreTestCases {

    Faker faker;
    Centre centrePayload;

    @BeforeClass
    public void setupData(){
        faker = new Faker();
        centrePayload = new Centre();
        centrePayload.setCentre_id(faker.name().firstName());
        centrePayload.setEmail_address(faker.internet().safeEmailAddress());
        centrePayload.setName(faker.name().firstName());
        centrePayload.setPhone_number(faker.phoneNumber().cellPhone());
        centrePayload.setStreet_address(faker.address().streetAddress());

    }
@Test(priority = 1)
public void abc(){

}
   @Test(priority = 1)
    public void testPostCentre(){

        Response response = CentreEndpoints.createCentre(centrePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
       ResponseData.centre_id = response.jsonPath().get("data.centre_id");

    }

    @Test(priority = 2)
    public void testPatchCentre(){
        //update name
        centrePayload.setName(faker.name().firstName());
        Response response = CentreEndpoints.updateCentre(this.centrePayload.getCentre_id(),centrePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
    @Test(priority = 3)
    public void testGetCentre(){
        Response response = CentreEndpoints.getCentre(this.centrePayload.getCentre_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().get("data.name"),this.centrePayload.getName(),"Name doesn't get updated!");
    }

   @Test(priority = 4)
    public void testListCentres(){
        Response response = CentreEndpoints.listCentres();
       response.then().log().all();

       Assert.assertEquals(response.getStatusCode(),200);
       Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");


   }
}
