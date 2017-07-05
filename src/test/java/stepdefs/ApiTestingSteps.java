package stepdefs;

import actions.ApiTestMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
public class ApiTestingSteps {

    ApiTestMethods apiTestmethods = new ApiTestMethods();

    @Given("^that I want to find the distance between Edinburgh,UK and Glasgow,UK in imperial$")
    public void that_I_want_to_find_the_distance_between_Edinburgh_UK_and_Glasgow_UK_in_imperial() throws Throwable {
        apiTestmethods.getDistance("Edinburgh,UK","Glasgow,UK","imperial",200);
    }

    @Given("^that I want to find the distance between Washington,DC and New York City, NY in metric$")
    public void that_I_want_to_find_the_distance_between_Washington_DC_and_New_York_City_NY_in_metric() throws Throwable {
        apiTestmethods.getDistance("Washington,DC","New York City,NY","metric",200);

    }


    @When("^I send valid request to Distance Matrix API$")
    public void i_send_the_request_to_Distance_Matrix_API() throws Throwable {
        
    }

    @Then("^the status is 'OK'$")
    public void the_status_is_OK() throws Throwable {
        apiTestmethods.verifyOkResponseCode("OK");
    }


   @Given("^that I want to find the 'bicycling' time between 'origin' and 'destination'$")
    public void that_I_want_to_find_the_bicycling_time_between_origin_and_destination() throws Throwable {
        apiTestmethods.getTimeUsingBicycle();
    }
}
