package com.corevalue.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ovo on 24.01.2017.
 */
public class MortgagePage extends WebToolPage {

    @FindBy(xpath ="(//a[@href='http://ia.ca/mortgage-payment-calculator'])[2]" )
    private WebElement calculatePayments;

    public MortgagePage(WebDriver driver) {super(driver);}



    public WebElement getCalculatePayments() {
        return this.calculatePayments;
    }

    public CalculatorPage gotoCalculator() {
        waitAndClick(getCalculatePayments());
        return new CalculatorPage(driver);
    }
}
