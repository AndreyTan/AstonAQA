import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class EchoTest {

    @BeforeEach
    public void testInit() {
        baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGet() {
        given()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1")).and()
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {
        String reqDataBody = "raw text test";
        given()
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
        Map<String,String> req_body = new HashMap<>();

        req_body.put("foo1", "bar1");
        req_body.put("foo2", "bar2");
        req_body.put("foo3", "bar3");

        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                //.contentType(ContentType.URLENC)
                .accept(ContentType.ANY)
                .formParams(req_body)
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1")).and()
                .body("form.foo2", equalTo("bar2")).and()
                .body("form.foo3", equalTo("bar3"));
    }

    @Test
    public void testPut() {
        given()
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
