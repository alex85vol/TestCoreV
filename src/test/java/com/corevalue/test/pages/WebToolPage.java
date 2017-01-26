package com.corevalue.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ovo on 25.01.2017.
 */
public abstract class WebToolPage {

    protected WebDriver driver;

    protected final long DEFAULT_TIMEOUT = 5;

    public WebToolPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected boolean elementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return elementDisplayed(element);

        }

    }

    protected String getAtrributeValue(WebElement element) {
        return element.getAttribute("value");
    }

     protected String getText(WebElement element) {
        return element.getText();
    }


    protected void sendKeysTo(WebElement element, String keysSendToElement) {
        element.sendKeys(keysSendToElement);
    }

    protected void clear(WebElement element) {
        element.clear();
    }

    protected void clearAndSendKeys(WebElement element, String sendKeys) {
        clear(element);
        sendKeysTo(element, sendKeys);
    }

    protected void clickOn(WebElement element) {
        element.click();
    }

    protected void waitAndClick(WebElement element, long timeInSeconds) {
        new WebDriverWait(this.driver, timeInSeconds).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    protected void waitAndClick(WebElement element) {
        waitAndClick(element, DEFAULT_TIMEOUT);
    }


    protected void clickJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected WebElement intoView(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", e);
        return e;
    }




    protected WebElement waitForElementIsVisible(WebElement element, long timeoutInSeconds) {
        try {
            new WebDriverWait(this.driver, timeoutInSeconds).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            // nothing to do here
        }

        return element;
    }

    protected void sleepForLoad(int aWhile) {
        try {
            Thread.sleep(aWhile);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

