package com.mikalai.cucumber.test.fruit.steps;

import com.google.gson.Gson;
import com.mikalai.cucumber.fruit.Fruit;
import cucumber.api.java.en.Given;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Mikalai_Churakou on 3/23/2017.
 */
public class FruitSteps {
    @Given("^the system knows about the following fruit:$")
    public void theSystemKnowsAboutTheFollowingFruit(List<Fruit> fruitList) throws Throwable {
        Gson gson = new Gson();
        PrintWriter writer = new PrintWriter("fruit.json", "UTF-8");
        writer.println(gson.toJson(fruitList));
        writer.close();

    }


}
