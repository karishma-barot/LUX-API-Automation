package test;

import api.endpoints.ParticipantEndpoints;
import api.payload.Participant;
import api.utilities.ResponseData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParticipantTestCases {
    Participant participantPayload;

    @BeforeClass
    public void dataSetup(){
        participantPayload = new Participant();
        participantPayload.setKind("Centre");
        participantPayload.setKind_id("47460");
    }

    @Test(priority = 1)
    public void testCreateParticipant(){
        Response response = ParticipantEndpoints.createParticipant(participantPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setParticipant_id(response.jsonPath().get("data.participant_id"));
    }

   /* @Test(priority = 2)
    public void testUpdateParticipant(){
        participantPayload.setLink_participants(new String[]{});
        Response response = ParticipantEndpoints.updateParticipant(ResponseData.getParticipant_id(),participantPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }*/

    @Test(priority = 3)
    public void testGetParticipant(){
        Response response = ParticipantEndpoints.getParticipant(ResponseData.getParticipant_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testListParticipants(){
        Response response = ParticipantEndpoints.listParticipants();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteParticipant(){
        Response response = ParticipantEndpoints.deleteParticipant(ResponseData.getParticipant_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
