package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.teller.Teller;
import com.mikalai.cucumber.test.account.hook.ServerHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;


/**
 * Created by mikalai on 3/18/2017.
 */

public class AtmUserInterface implements Teller {
    @Autowired
    private EventFiringWebDriver webDriver;

    public void withdrawFrom(Account account, int dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("Amount"))
                    .sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("Withdraw")).click();
    }

    public boolean isDisplaying(String message) {
        By locator = By.xpath("//*[contains(text(),'" + message + "')]");
        WebDriverWait wait = new WebDriverWait(webDriver, 2, 30);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));
        List<WebElement> list = webDriver.findElements(locator);
        return (list.size() > 0);
    }

    public void type(int amount) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        WebElement input = webDriver.findElement(By.id("Amount"));
        String amountString = String.valueOf(amount);
        input.sendKeys(amountString);
        ask("Ready to continue");
    }

    public void ask(String question) {
        JOptionPane.showMessageDialog(
                null,
                question,
                "Ask for response",
                JOptionPane.PLAIN_MESSAGE);
    }

}
