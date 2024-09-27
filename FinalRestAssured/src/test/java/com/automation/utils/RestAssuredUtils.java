package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {
    static RequestSpecification requestSpecification = RestAssured.given();
    static String endPoint;
    static Response response;

    public static void setEndPoint(String endPoint) {
        RestAssuredUtils.endPoint = endPoint;
    }

    // reusable methods
    public static Response post() {
        requestSpecification.log().all(); //just for logging purpose
        //Return object as response
        response = requestSpecification.post(endPoint);
        response.then().log().all();     //just for logging purpose
        return response;     //we need response object , when we use post and get method
    }

    public static Response get() {
        requestSpecification.log().all();
        response = requestSpecification.get(endPoint);
        response.then().log().all();
        return response;
    }
    public static Response delete() {
        requestSpecification.log().all();
        response = requestSpecification.delete(endPoint);
        response.then().log().all();
        return response;
    }

    public static Response put() {
        requestSpecification.log().all(); //just for logging purpose
        //Return object as response
        response = requestSpecification.put(endPoint);
        response.then().log().all();     //just for logging purpose
        return response;
    }

    //to set the header
    public static void setHeader(String key, String value) {
        requestSpecification = requestSpecification.header(key, value);
    }

    public static void setBodyUsingPojo(Object object) {
        requestSpecification = requestSpecification.body(object);
    }

    public static int getStatusCode() {
        return response.getStatusCode();
    }

    //Get data from file
    public static String getDataFormatFile(String filePath) {
        String content = null;
        try {
            content = new Scanner(new FileInputStream(filePath)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static Response getResponse() {
        return response;

    }


}

