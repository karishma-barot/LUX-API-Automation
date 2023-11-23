package test;

import api.endpoints.DealEndpoints;
import api.utilities.ResponseData;



import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;




public class DealTestCases {

    @Test(priority = 1)
    public void testCreateDeal(){

        String jsonPayload = "{\n" +
                "    \"ends_at\": \"2024-03-21T21:43:56Z\",\n" +
                "    \"published_at\": \"2023-11-21T12:43:56Z\",\n" +
                "    \"starts_at\": \"2023-11-21T12:43:56Z\",\n" +
                "    \"stores\": [\n" +
                "        {\n" +
                "            \"centre_id\": \"montgomery\",\n" +
                "            \"store_id\": 6449,\n" +
                "            \"retailer_id\": 4292\n" +
                "        }\n" +
                "    ],\n" +
                "    \"support_diffusions\": [\n" +
                "        0\n" +
                "    ],\n" +
                "    \"title\": \"abc\"\n" +
                "}";

       Response response = DealEndpoints.createDeal(jsonPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setDeal_id(response.jsonPath().get("data.deal_id"));
    }
    @Test(priority = 2)
    public void testUpdateDeal(){
        String title = "{\n" +
                "        \"title\": \"new title\"" +
                "}";
        Response response = DealEndpoints.updateDeal(ResponseData.getDeal_id(),title);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

    @Test(priority = 3)
    public void testGetDeal(){
        Response response = DealEndpoints.getDeal(ResponseData.getDeal_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testListDeals(){
        Response response = DealEndpoints.listDeals();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteDeal(){
        Response response = DealEndpoints.deleteDeal(ResponseData.getDeal_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

}
