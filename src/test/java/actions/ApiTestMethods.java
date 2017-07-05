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
    private DistanceApiResponse r;

    public void verifyInvalidRequestResponseCode(String expectedCode){
        Assert.assertEquals(expectedCode, r.status);
    }

    public void verifyOkResponseCode(String expectedCode){
        Assert.assertEquals(expectedCode, r.rows[0].elements[0].status);
    }

    public void getDistance(String origin, String destination, String unit, int status){

        response = RestAssuredCore.findDistanceInUnits(origin, destination, unit, status);
        //RestAssuredCore.printResponse(response);
         r = new Gson().fromJson(response.asString(), DistanceApiResponse.class);
        System.out.println("\n"+"Distance between "+origin+" & "+destination+" is "+r.rows[0].elements[0].distance.text+"\n");

    }

    public void getTimeUsingBicycle(){

        response = RestAssuredCore.findTravelTime();
        //RestAssuredCore.printResponse(response);
        r = new Gson().fromJson(response.asString(), DistanceApiResponse.class);
        System.out.println("The bicycling time"+" is "+r.rows[0].elements[0].duration.text+"\n");

    }

}
