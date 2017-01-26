package com.corevalue.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by ovo on 24.01.2017.
 */
public class MainPage extends WebToolPage {



    //region Webelements
    @FindBy(xpath = "//i[@class='icone-home']")
    private WebElement logo;
    @FindBy(xpath ="//i[@class='icone-menu-prets']" )
    private WebElement loans;
    @FindBy(xpath = "//a[@data-utag-name='mortgage_loan']")
    private WebElement mortgage;
    //endregion


    public MainPage(WebDriver driver) { super(driver);}


    //region Webelements Getters
    public WebElement getLogo() {
        return this.logo;
    }

    public WebElement getLoans() {
        return this.loans;
    }

    public WebElement getMortgage() {
        waitForElementIsVisible(mortgage,5);
        return this.mortgage;
    }
    //endregion


    //region MainPage Methods
    public void checkPage() {
        Assert.assertTrue(getLogo().isDisplayed(), "Page isn't successfully loaded");
    }

    public MortgagePage gotoMortgagePage() {
       getLoans().click();
       getMortgage().click();
       return new MortgagePage(driver);
    }
    //endregion

}

