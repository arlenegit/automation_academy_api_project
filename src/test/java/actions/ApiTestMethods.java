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
        System.out.println("Distance between "+origin+" & "+destination+" is "+r.rows[0].elements[0].distance.text+"\n");

    }

    public void getTimeUsingBicycle(String origin, String destination, String mode, int status){

        response = RestAssuredCore.findTravelTime(origin, destination, mode, status);
        //RestAssuredCore.printResponse(response);
        r = new Gson().fromJson(response.asString(), DistanceApiResponse.class);
        System.out.println("Time taken to travel between "+origin+" & "+destination+" using bicycle"+" is "+r.rows[0].elements[0].duration.text+"\n");


    }


}
