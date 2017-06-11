package restassured;

import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class RestAssuredCore {


    public static ExtractableResponse fetchGetResponse(final String origin, final String destination, final String unit, final int status){

        return given().contentType("application/json").param("origins", origin).param("destinations", destination).param("units", unit).when().get("https://maps.googleapis.com/maps/api/distancematrix/json").then()
                .assertThat().statusCode(is(status)).extract();
    }

    public static void printResponse(final ExtractableResponse response){
        response.response().body().prettyPrint();
    }

//    public static ExtractableResponse postAsMultipartAndReturnResponse(final String postDestination, final String jsonBody, final String attachmentPath, final int status) {
//
//        return given().headers(mappedValues).contentType("multipart/form-data").multiPart(new File(attachmentPath)).param("JsonParameters", jsonBody).when().post(postDestination).then()
//                .assertThat().statusCode(is(status)).extract();
//    }

}
