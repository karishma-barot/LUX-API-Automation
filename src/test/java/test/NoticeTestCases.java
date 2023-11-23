package test;

import api.endpoints.NoticeEndpoints;
import api.payload.Notice;
import api.utilities.ResponseData;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NoticeTestCases {
    Notice noticepayload;
    Faker faker;

    @BeforeClass
    public void dataSetup(){
        noticepayload = new Notice();
        faker = new Faker();
        noticepayload.setCentre_id("montgomery");
        noticepayload.setDetail(faker.name().fullName());
        noticepayload.setExpires_at("2024-03-21T21:43:56Z");
        noticepayload.setPublished_at("2023-11-12T21:43:56Z");
        noticepayload.setImage_ref(faker.internet().url());
        noticepayload.setImg_alt_text(faker.name().title());
        noticepayload.setName(faker.name().firstName());

    }

    @Test(priority = 1)
    public void testCreateNotice(){
        Response response = NoticeEndpoints.createNotice(noticepayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        ResponseData.setNotice_id(response.jsonPath().get("data.notice_id"));
    }

    @Test(priority = 2)
    public void testUpdateNotice(){
        noticepayload.setName(faker.name().firstName());
        Response response = NoticeEndpoints.updateNotice(ResponseData.getNotice_id(),noticepayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }

    @Test(priority = 3)
    public void testGetNotice(){
        Response response = NoticeEndpoints.getNotice(ResponseData.getNotice_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void testListNotices(){
        Response response = NoticeEndpoints.listNotices();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getMap("meta").containsKey("page_count"), "Page count not found in the response");
    }

    @Test(priority = 5)
    public void testDeleteNotice(){
        Response response = NoticeEndpoints.deleteNotice(ResponseData.getNotice_id());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
