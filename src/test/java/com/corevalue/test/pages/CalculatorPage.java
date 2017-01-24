package com.corevalue.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ovo on 24.01.2017.
 */
public class CalculatorPage extends MainPage {

    //region webelements field
    private WebElement purchasePriceSlider;
    private WebElement purchasePriceField;
    private WebElement purchasePriceIncreaseButton;
    private WebElement downPaymentIncreaseButton;
    private WebElement downPaymentField;
    private WebElement amortizationField;
    private WebElement amortizationValue;
    private WebElement paymentFrequency;
    private WebElement interestRateField;


    //endregion

    public CalculatorPage(WebDriver driver) {
        super(driver);
        this.purchasePriceSlider = driver
                .findElement(By.xpath(("//div[@class='slider-handle min-slider-handle custom'])[1]")));
        this.purchasePriceField = driver.findElement(By.xpath("//input[@id='PrixPropriete']"));
        this.purchasePriceIncreaseButton = driver
                .findElement(By.xpath("//button[@class='PrixProprietePlus']"));
        this.downPaymentIncreaseButton = driver.findElement(By.xpath("//button[@id='MiseDeFondPlus']"));
        this.downPaymentField =driver.findElement(By.xpath("//input[@id='MiseDeFond']"));


    }
}
