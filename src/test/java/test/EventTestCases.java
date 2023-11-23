package test;

import api.endpoints.EventEndpoints;
import api.utilities.ResponseData;
import api.utilities.RetryAnalyzer;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventTestCases {

    @Test(priority = 1)
    public void testCreateEvent(){
        String jsonPayload = "{\n" +
                "  \"centre_id\": \"centurycity\",\n" +
                "  \"name\": \"0.1% off on all products\",\n" +
                "  \"support_diffusions\": [1],\n" +
                "  \"published_at\":\"2023-11-12T12:34:56.000Z\",\n" +
                "  \"occurrences\": [{\n" +
                "      \"starts_at\": \"2023-11-12T12:34:56.000Z\",\n" +
                "      \"finishes_at\": \"2023-12-12T12:34:56.000Z\"\n" +
                "  }]\n" +
                "}";

        Response response = EventEndpoints.creatEvent(jsonPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setEvent_id(response.jsonPath().get("data.event_id"));
    }
    @Test(priority = 2)
    public void testUpdateEvent(){
        String name = "{\n" +
                "        \"name\": \"new name\"" +
                "}";
        Response response = EventEndpoints.updateEvent(ResponseData.getEvent_id(),name);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

    @Test(priority = 3)
    public void testGetEvent(){
        Response response = EventEndpoints.getEvent(ResponseData.getEvent_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void testListEvents(){
        Response response = EventEndpoints.listEvents();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteEvent(){
        Response response = EventEndpoints.deleteEvent(ResponseData.getEvent_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
