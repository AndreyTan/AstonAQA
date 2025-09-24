import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class EchoTest {

    @BeforeEach
    public void testInit() {
        baseURI = "https://postman-echo.com";
    }

    @Test
    public void testFirstGet() {
        /*
        Response response = get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
        System.out.println(response.getStatusCode());
        */

        given()
                .get("/get?foo1=bar1&foo2=bar2").then().statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .and()
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {
        String reqDataBody = "sdfsfsfa";
        given()
                .header("Content-Type", "text/plain")
                .contentType(ContentType.TEXT)
                .accept(ContentType.ANY)
                .body(reqDataBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(reqDataBody));

    }

    @Test
    public void testPostForm() {
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("yolo", "yo1");
        bodyJson.put("bolo", "bobo");


        given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                //.header("Content-Type",ContentType.URLENC)
                .contentType(ContentType.URLENC)
                .accept(ContentType.ANY)
                .body(bodyJson.toJSONString())
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.yolo", equalTo("yo1")).and()
                .body("form.bolo", equalTo("bobo"));
    }

    @Test
    public void testPut() {
        given()
                .header("Content-Type", "text/plain")
                .contentType(ContentType.TEXT)
                .accept(ContentType.ANY)
                .body("any put text")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("any put text"));
    }

    @Test
    public void testPatch() {
        given()
                .header("Content-Type", "text/plain")
                .contentType(ContentType.TEXT)
                .accept(ContentType.ANY)
                .body("any raw patch text")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("any raw patch text"));
    }

    @Test
    public void testDelete() {
        given()
                .header("Content-Type", "text/plain")
                .contentType(ContentType.TEXT)
                .accept(ContentType.ANY)
                .body("delete text")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("delete text"));
    }

}
