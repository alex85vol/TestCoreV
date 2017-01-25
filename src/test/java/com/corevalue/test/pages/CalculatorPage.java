package com.corevalue.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ovo on 24.01.2017.
 */
public class CalculatorPage extends MainPage  {


    //region webelements field
    @FindBy(xpath = "//div[@class='slider-handle min-slider-handle custom'])[1]")
    private WebElement purchasePriceSlider;
    @FindBy(xpath = "//input[@id='PrixPropriete']")
    private WebElement purchasePriceField;
    @FindBy(xpath = "//button[@class='PrixProprietePlus']")
    private WebElement purchasePriceIncreaseButton;
    @FindBy(xpath = "//button[@id='MiseDeFondPlus']")
    private WebElement downPaymentIncreaseButton;
    @FindBy(xpath = "//input[@id='MiseDeFond']")
    private WebElement downPaymentField;
    @FindBy
    private WebElement amortizationField;
    @FindBy(xpath = "//select[@id='Amortissement']/option[@value='" +  "']")
    private WebElement amortizationValue;
    private WebElement paymentFrequency;
    private WebElement interestRateField;
    private WebElement calculateButton;


    //endregion

    public CalculatorPage(WebDriver driver) {super(driver);}

    public WebElement getPurchasePriceField(){return this.purchasePriceField;}
    public WebElement
}

