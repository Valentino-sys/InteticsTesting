import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookSentences {

    @When("I am sending a request to get a book with id <id>")
    public void getRequest(@Named("id")int id) {
        given().when().get("https://www.goodreads.com/buttons/preview/id");
    }

    @Then("Request was performed successfully")
    public void requestResult() {
        given().then().statusCode(200);
    }

    @Then("The result of the request is returned id = <id>")
    public void resultOfReturned(@Named("id")int id) {
        given().then().body("book_id", equalTo(id));
    }
}
