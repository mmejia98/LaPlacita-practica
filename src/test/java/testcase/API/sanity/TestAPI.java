package testcase.API.sanity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class TestAPI {

    @Test
    public void testGet(){
        Response response = get("https://reqres.in/api/users?page=2");
        //get("https://reqres.in/api/users/2").then().body("data.id", equalTo(2));
        given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id", equalTo(2));
    }

    @Test
    public void post(){
        JSONObject request = new JSONObject();
        request.put("name", "Mario");
        request.put("job", "Tester");
        given().header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .log().all();
    }

    @Test
    public void put(){
        JSONObject request = new JSONObject();
        request.put("name", "Mario");
        request.put("job", "Tester");

        given().header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when().put("https://reqres.in/api/users/2")
                .then().statusCode(200)
                .log().all();
    }

    @Test
    public void delete(){
        given().header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().delete("https://reqres.in/api/users/2")
                .then().statusCode(204);
    }

}
