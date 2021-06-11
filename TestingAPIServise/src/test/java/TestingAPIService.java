
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestingAPIService {
    private URL url;
    Response response;
    JSONObject body;
    int[] validTasks = {12};
    int[] validCompanies = {36, 37};
    int [] invalid = {12, 12, 34, 56, 78};
    String [] invalidField = {"11@#$%^&"};

    public TestingAPIService() {
        this.url = URL.URL_API;
    }


    @When("I send a request to create a user with all fields $/createuser")
    public void postRequestWithAllFields(@Named("url") String endPoint) {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        body.put("hobby", "Стрельба из лука, Настолки");
        body.put("adres", "Novovilenskaya 26");
        body.put("name1", "Volodya Test");
        body.put("surname1", "Testovich");
        body.put("fathername1", "Testovich");
        body.put("cat", "Маруся");
        body.put("dog", "Ушастый");
        body.put("parrot", "Васька");
        body.put("cavy", "Кто ты?");
        body.put("hamster", "Хомяк");
        body.put("squirrel", "Белая горячка к нам пришла");
        body.put("phone", "333 33 33");
        body.put("inn", "123456789012");
        body.put("gender", "m");
        body.put("birthday", "01.01.1900");
        body.put("date_start", "11.11.2000");
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @Then("I get the positive status")
    public void statusCode() {
        assertThat(response.statusCode(), equalTo(200));
    }

    @When("I send a request to create a user only with required fields $/createuser")
    public void postWithRequiredFields(@Named("url") String endPoint) {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @When("I send a request to create a user without one required field $/createuser")
    public void requestWithoutAnyRequiredField() {
        body = new JSONObject();
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @Then("I get the negative status")
    public void negativeStatusCode() {
        assertThat(response.statusCode(), equalTo(200)); // должен быть 400
    }

    @When("I'm sending a valid email")
    public void requestWithValidEmail() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @When("I'm sending a invalid email")
    public void requestWithInvalidEmail() {
        body = new JSONObject();
        body.put("email", "testUser@&&&*&*&*^$%$mailinator.com");
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @When("I'm sending a valid name")
    public void requestWithValidName() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @When("I'm sending a empty name")
    public void requestWithInvalidName() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "");
        body.put("tasks", validTasks);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @When("I enter several values in the tasks field")
    public void requestWithSeveralValuesInTasks() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "");
        body.put("tasks", invalid);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }


    @When("I'm sending a invalid tasks")
    public void requestWithInvalidTasks() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "");
        body.put("tasks", invalidField);
        body.put("companies", validCompanies);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }

    @When("I enter several values in the companies field")
    public void requestWithSeveralValuesInCompanies() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "volodya");
        body.put("tasks", validTasks);
        body.put("companies", invalid);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }


    @When("I'm sending a invalid companies")
    public void requestWithInvalidCompanies() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("name", "");
        body.put("tasks", validTasks);
        body.put("companies", invalidField);
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.post("http://users.bugred.ru/tasks/rest/createuser");
    }


    @When("I send a request to get data about user $/getuser")
    public void getRequestWithValidEmail() {
        response = given().param("email", "testUser@mailinator.com").when().get("http://users.bugred.ru/tasks/rest/getuser");
    }

    @When("I'm entering a non-existent user $/getuser")
    public void getRequestWithNonExistentUser() {
        response = given().param("email", "testUs@mailinator.com").when().get("http://users.bugred.ru/tasks/rest/getuser");
    }

    @When("I'm sending a put request with an existing email")
    public void putRequestWithValidEmail() {
        body = new JSONObject();
        body.put("email", "testUser@mailinator.com");
        body.put("field", "name");
        body.put("value", "Igor");
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.put("http://users.bugred.ru/tasks/rest/useronefield");
    }

    @When("I am sending a put request with a non-existent e-mail")
    public void putRequestWithNonExistentEmail() {
        body = new JSONObject();
        body.put("email", "testU@mailinator.com");
        body.put("field", "name");
        body.put("value", "Igor");
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.put("http://users.bugred.ru/tasks/rest/useronefield");
    }

    @When("I am sending a body without one required field")
    public void putRequestWithoutRequiredField() {
        body = new JSONObject();
        body.put("email", "testU@mailinator.com");
        body.put("value", "Igor");
        RequestSpecification requestSpecification = given();
        requestSpecification.body(body.toString());
        response = requestSpecification.put("http://users.bugred.ru/tasks/rest/useronefield");
    }

    @When("I am sending delete request with invalid email")
    public void deleteRequestWithInvalidEmail() {
        response = given().param("email", "test@mailinator.com").when().delete("http://users.bugred.ru/tasks/rest/deleteuser");
    }

    @When("I am sending delete request with valid email")
    public void deleteRequestWithValidEmail() {
        response = given().param("email", "testUser@mailinator.com").when().delete("http://users.bugred.ru/tasks/rest/deleteuser");
    }

}


