package com.mikalai.cucumber.test.fruit.steps;

import com.google.gson.JsonParser;
import com.mikalai.cucumber.test.fruit.hook.ServerHook;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.net.HttpURLConnection;

/**
 * Created by Mikalai_Churakou on 3/23/2017.
 */
public class RestSteps {
    private ClientResponse response;

    @When("^the client requests GET /fruits$")
    public void theClientRequestsGETFruits() throws Throwable {
        try {
            Client client = Client.create();
            WebResource webResource = client
                    .resource("http://localhost:" + ServerHook.PORT + "/fruits");
            response = webResource.type("application/json")
                    .get(ClientResponse.class);
        } catch (RuntimeException r) {
            throw r;
        } catch (Exception e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }
        Assert.assertEquals("Did not receive OK response: ",
                HttpURLConnection.HTTP_OK, response.getStatus());
    }

    @Then("^the response should be JSON:$")
    public void theResponseShouldBeJSON(String jsonExpected) throws Throwable {
        JsonParser parser = new JsonParser();
        Assert.assertEquals("Unexpected JSON.",
                parser.parse(jsonExpected), parser.parse(response.getEntity(String.class)));

    }
}
