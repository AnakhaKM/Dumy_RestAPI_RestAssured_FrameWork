package com.automation.steps;

import com.automation.pojo.CreateRecordPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        if (endPoint.contains("@")) {
            String Id = ConfigReader.getConfigValue("record.id");
            endPoint = endPoint.replace("@id", Id);
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }


    @And("set request body from the file {string} using pogo class")
    public void setRequestBodyFromTheFileUsingPogoClass(String fileName) throws JsonProcessingException {
        String jsonFolderPath = ConfigReader.getConfigValue("json.folder.path");
        String jsonBody = RestAssuredUtils.getDataFormatFile(jsonFolderPath + fileName);
        ObjectMapper om = new ObjectMapper();
        CreateRecordPojo createRecordPojo = om.readValue(jsonBody, CreateRecordPojo.class);
        RestAssuredUtils.setBodyUsingPojo(createRecordPojo);

    }

    @When("user performs post call")
    public void userPerformsPostCall() {
        RestAssuredUtils.post();

    }

    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredUtils.get();
    }

    @When("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }

    @When("user performs put call")
    public void userPerformsPutCall() {
    }
}
