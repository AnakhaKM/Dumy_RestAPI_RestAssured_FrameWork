package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class ResponseSteps {
    @And("verify id is not empty")
    public void verifyIdIsNotEmpty() {
        String Id=RestAssuredUtils.getResponse().jsonPath().getString("id");
        Assert.assertTrue(!Id.isEmpty());
    }


    @And("stores created id into {string}")
    public void storesCreatedIdInto(String key) {
        ConfigReader.setConfigValue(key,RestAssuredUtils.getResponse().jsonPath().getString("id"));

    }

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }
}
