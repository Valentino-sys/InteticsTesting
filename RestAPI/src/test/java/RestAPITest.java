
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAPITest {
    private int expectedResponseCode;

    public RestAPITest() {
        this.expectedResponseCode = 200;
    }

    @Test
    public void getStatusCodeTest() {
        given().when().get("https://images-api.nasa.gov/").then().assertThat().statusCode(expectedResponseCode);
    }

    @Test
    public void postStatusCodeTest() {
        Map<String, String> params = new HashMap<>();
        params.put("password", "Axa@Demo");
        params.put("username", "selenium_chrome");
        params.put("grant_type", "password");
        params.put("scope", "deltix.axa.user");
        given().header("Authorization", "Basic d2ViYXBwOg==").contentType(ContentType.URLENC).formParams(params)
                .post("https://app.tca.deltixuat.com/oauth/token").then().assertThat().statusCode(expectedResponseCode);
    }

}
