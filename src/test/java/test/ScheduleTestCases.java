package test;

import api.endpoints.ScheduleEndpoints;
import api.payload.Schedule;
import api.utilities.ResponseData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScheduleTestCases {

    Schedule schedulePayload;

    @BeforeClass
    public void dataSetup(){
        schedulePayload = new Schedule();
        schedulePayload.setName("abc");
        schedulePayload.setType("custom_trading");
        schedulePayload.setTime_zone("Australia/Sydney");
        schedulePayload.setParticipant_id(144882);
    }
    @Test(priority = 1)
    public void testCreateSchedule(){
        Response response = ScheduleEndpoints.createSchedule(schedulePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setSchedule_id(response.jsonPath().get("data.schedule_id"));
    }

    @Test(priority = 2)
    public void testUpdateSchedule(){
        schedulePayload.setName("abc");
        Response response = ScheduleEndpoints.updateSchedule(ResponseData.getSchedule_id(),schedulePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

    @Test(priority = 3)
    public void testGetSchedule(){
        Response response = ScheduleEndpoints.getSchedule(ResponseData.getSchedule_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testListSchedules(){
        Response response = ScheduleEndpoints.listSchedules();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteSchedule(){
        Response response = ScheduleEndpoints.deleteSchedule(ResponseData.getSchedule_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
