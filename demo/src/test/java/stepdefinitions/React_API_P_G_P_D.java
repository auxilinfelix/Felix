package stepdefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import common.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class React_API_P_G_P_D extends BaseClass {

    private String trainingId;
    private Response response;
    private String responseBody;

    @Given("The base URI of API is {string}")
    public void the_base_uri_of_api_is(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    @When("I send a POST request to the API with endpoint {string} and name {int}")
    public void i_send_a_post_request_to_the_api_with_endpoint_and_name(String endpoint1, Integer int1) {

        int number = int1;
        String randStr = BaseClass.randomString(number);

        response = given().log().all().header("Content-Type", "application/json")
                .body("{\r\n" +
                        "    \"employeeName\": \"" + randStr + "\",\r\n" +
                        "    \"course\": \"Playwright\",\r\n" +
                        "    \"startDate\": \"2025-05-17T00:00:00.000Z\",\r\n" +
                        "    \"endDate\": \"2025-05-18T00:00:00.000Z\",\r\n" +
                        "    \"status\": \"In Progress\",\r\n" +
                        "    \"trainerName\": \"efZyFj\",\r\n" +
                        "    \"trainingType\": \"Virtual\",\r\n" +
                        "    \"percentCompleted\": 82,\r\n" +
                        "    \"projectName\": \"ABC\"\r\n" +
                        "}")
                .when().post(endpoint1);

        responseBody = response.then().log().all().assertThat().statusCode(201).extract().asString();
        trainingId = response.jsonPath().getString("_id");
        BaseClass.userID = trainingId;

    }

    @Then("I should receive the post response")
    public void i_should_receive_the_post_response() {
        System.out.println("POST response: " + responseBody);
    }

    @Then("verify the status code is {string} and post request is successful in API")
    public void verify_the_status_code_is_and_post_request_is_successful_in_api(String expectedStatusCode) {

        int expected = Integer.parseInt(expectedStatusCode);
        int actual = response.getStatusCode();

        if (expected == actual) {
            System.out.println("Post request is successful in API and new training created");
        } else {
            System.out.println("Error code received!");
        }

    }

    @Then("validate if a new training is CREATED in the Web")
    public void validate_if_a_new_training_is_created_in_the_web() throws InterruptedException {

        driver.get("http://10.192.190.130:3000/");
        Thread.sleep(1000);
        boolean isPresent = !driver.findElements(By.xpath(
                "//td[text()='Playwright'][contains(@class,'MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-18u8qr0-MuiTableCell-root')]"))
                .isEmpty();

        Assert.assertTrue(isPresent);
        System.out.println("New training record is created in Web");

    }

    @When("I send a PUT request to the API with endpoint {string} and name {int}")
    public void i_send_a_put_request_to_the_api_with_endpoint_and_name(String endpoint2, Integer int2) {
        if (BaseClass.userID == null)
            throw new IllegalStateException("Training ID is null. Ensure POST ran before PUT.");
        int number2 = int2;
        String name2 = RandomStringUtils.randomAlphabetic(number2);

        response = given().log().all().header("Content-Type", "application/json")
                .body("{\r\n" +
                        "    \"employeeName\": \"" + name2 + "\",\r\n" +
                        "    \"course\": \"Playwright\",\r\n" +
                        "    \"startDate\": \"2025-05-17T00:00:00.000Z\",\r\n" +
                        "    \"endDate\": \"2025-05-18T00:00:00.000Z\",\r\n" +
                        "    \"status\": \"In Progress\",\r\n" +
                        "    \"trainerName\": \"efZyFj\",\r\n" +
                        "    \"trainingType\": \"Virtual\",\r\n" +
                        "    \"percentCompleted\": 82,\r\n" +
                        "    \"projectName\": \"ABC\"\r\n" +
                        "}")
                .when().put(endpoint2 + BaseClass.userID);

        responseBody = response.then().log().all().assertThat().statusCode(200).extract().asString();

    }

    @Then("I should receive the put response")
    public void i_should_receive_the_put_response() {
        System.out.println("PUT response: " + responseBody);
    }

    @Then("the status code contains {string} and put request is successful in API")
    public void the_status_code_contains_and_put_request_is_successful_in_api(String code2) {
        int expected2 = Integer.parseInt(code2);
        int actual2 = response.getStatusCode();

        if (expected2 == actual2) {
            System.out.println("Put request is successful in API and training record got updated.");
        } else {
            System.out.println("Error code received!");
        }

    }

    @Then("validate if the corresponding record got UPDATED in the Web")
    public void validate_if_the_corresponding_record_got_updated_in_the_web() throws InterruptedException {

        driver.get("http://10.192.190.130:3000/");
        Thread.sleep(1000);
        boolean isPresent1 = !driver.findElements(By.xpath(
                "//td[text()='Playwright'][contains(@class,'MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-18u8qr0-MuiTableCell-root')]"))
                .isEmpty();

        Assert.assertTrue(isPresent1);
        System.out.println("Training record got updated in Web!");

    }

    @When("I send a GET request to the API with endpoint {string}")
    public void i_send_a_get_request_to_the_api_with_endpoint(String endpoint3) {
        response = given().log().all().header("Content-Type", "application/json")
                .when().get(endpoint3);

        responseBody = response.then().log().all().assertThat().statusCode(200).extract().asString();
    }

    @Then("I should receive the response")
    public void i_should_receive_the_response() {
        System.out.println("GET response: " + responseBody);
    }

    @Then("the status code is {string}")
    public void the_status_code_is(String expectedStatusCode) {
        int expectedCode = Integer.parseInt(expectedStatusCode);
        int actualCode = response.getStatusCode();
        System.out.println(actualCode == expectedCode ? "GET request successful." : "GET request failed.");
    }

    @When("I send a DELETE request to the API with endpoint {string}")
    public void i_send_a_delete_request_to_the_api_with_endpoint(String endpoint4) {
        if (BaseClass.userID == null)
            throw new IllegalStateException("Training ID is null. Ensure POST ran before DELETE.");

        response = given().log().all().header("Content-Type", "application/json")
                .when().delete(endpoint4 + BaseClass.userID);
    }

    @Then("I should receive the delete response")
    public void i_should_receive_the_delete_response() {
        System.out.println("DELETE response status code: " + response.getStatusCode());
    }

    @Then("verify if the status code has {string} and delete request is successful in API")
    public void verify_if_the_status_code_has_and_delete_request_is_successful_in_api(String code4) {

        int expectedCode4 = Integer.parseInt(code4);
        int actualCode4 = response.getStatusCode();
        if (actualCode4 == expectedCode4) {
            System.out.println("Delete request is successful in API and training record got deleted.");
        } else {
            System.out.println("Delete failed.");
        }

    }

    @Then("validate if the corresponding record got DELETED in the Web")
    public void validate_if_the_corresponding_record_got_deleted_in_the_web() throws InterruptedException {
        driver.get("http://10.192.190.130:3000/");
        Thread.sleep(1000);
        boolean empty = driver.findElements(By.xpath(
                "//td[text()='Playwright'][contains(@class,'MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-18u8qr0-MuiTableCell-root')]"))
                .isEmpty();

        Assert.assertTrue(empty);
        System.out.println("Training record got deleted in Web!");

    }
    
}
