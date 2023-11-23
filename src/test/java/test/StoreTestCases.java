package test;

import api.endpoints.StoreEndpoints;
import api.payload.Store;
import api.utilities.ResponseData;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTestCases {
    Store storePayload;
    Faker faker;

    @BeforeClass
    public void dataSetup(){
        storePayload = new Store();
        faker = new Faker();
        storePayload.setCategory_ids(new int[]{96,97});
        storePayload.setCentre_id("montgomery");
        storePayload.setName(faker.name().firstName());
        storePayload.setRetailer_id(4308);
        storePayload.setSalience(0);
        storePayload.setStore_type_ids(new int[]{1036});

    }
    @Test(priority = 1)
    public void testCreateStore(){

        Response response = StoreEndpoints.createStore(storePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setStore_id(response.jsonPath().get("data.store_id"));
    }

    @Test(priority = 2)
    public void testUpdateStore(){
        String status = "{\n" +
                "    \"status\": {\n" +
                "        \"ends_at\": \"2024-11-21T00:00:00Z\",\n" +
                "        \"publish_at\": \"2023-11-12T00:00:00Z\",\n" +
                "        \"starts_at\": \"2023-11-12T00:00:00Z\",\n" +
                "        \"state\": \"approve\"\n" +
                "    }\n" +
                "}";
        Response response = StoreEndpoints.updateStore(ResponseData.getStore_id(),status);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

    @Test(priority = 3)
    public void testGetStore(){
        Response response = StoreEndpoints.getStore(ResponseData.getStore_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().get("data.enabled"));
    }

    @Test(priority = 4)
    public void testListStores(){
        Response response = StoreEndpoints.listStore();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }
}
