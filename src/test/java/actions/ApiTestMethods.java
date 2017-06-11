package actions;

import com.google.gson.Gson;
import com.jayway.restassured.response.ExtractableResponse;
import org.junit.Assert;
import apiResponse.distanceMetric.DistanceApiResponse;
import restassured.RestAssuredCore;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class ApiTestMethods {

    private ExtractableResponse response;

    public void verifyInvalidRequestResponseCode(String expectedCode){
        DistanceApiResponse r = new Gson().fromJson(response.asString(), DistanceApiResponse.class);
        Assert.assertEquals(expectedCode, r.status);
    }

    public void verifyOkResponseCode(String expectedCode){
        DistanceApiResponse r = new Gson().fromJson(response.asString(), DistanceApiResponse.class);
        Assert.assertEquals(expectedCode, r.rows[0].elements[0].status);
    }

    public void getDistance(String origin, String destination, String unit, int status){

        response = RestAssuredCore.fetchGetResponse(origin, destination, unit, status);

        RestAssuredCore.printResponse(response);

    }


}
