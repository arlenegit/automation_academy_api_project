package restassured;

import com.jayway.restassured.response.ExtractableResponse;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class RestAssuredCore {


    public static ExtractableResponse findDistanceInUnits(final String origin, final String destination, final String unit, final int status){

        return given()
                .contentType("application/json")
                .param("origins", origin)
                .param("destinations", destination)
                .param("units", unit)
                .param("key", ApiSettings.API_KEY)
                .when()
                .get(ApiSettings.DISTANCE_URI)
                .then()
                .assertThat()
                .statusCode(is(status))
                .extract();
    }

    /*public static ExtractableResponse findTravelTime(final String origin, final String destination, final String mode, final int status){

        return given()
                .contentType("application/json")
                .param("origins", origin)
                .param("destinations", destination)
                .param("mode", mode)
                .param("key", ApiSettings.API_KEY)
                .when()
                .get(ApiSettings.DISTANCE_URI)
                .then()
                .assertThat()
                .statusCode(is(status))
                .extract();
    }*/

    public static ExtractableResponse findTravelTime(){

        return given()
                .contentType("application/json")
                .param("origins", "York,UK")
                .param("destinations", "Durham,UK")
                .param("mode", "bicycling")
                .param("key", ApiSettings.API_KEY)
                .when()
                .get(ApiSettings.DISTANCE_URI)
                .then()
                .assertThat()
                .statusCode(is(200))
                .extract();
    }

    public static void printResponse(final ExtractableResponse response){
        response
                .response()
                .body()
                .prettyPrint();
    }

}
