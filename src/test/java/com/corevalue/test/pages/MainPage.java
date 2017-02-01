package com.corevalue.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by ovo on 24.01.2017.
 */
public class MainPage extends WebToolPage {

///

    //region Webelements
    @FindBy(xpath = "//a[@id='topLangMenuItem']")
    private WebElement languageIcon;
    @FindBy(xpath = "//i[@class='icone-home']")
    private WebElement logo;
    @FindBy(xpath = "//a[@href='/individuals/pret']")
    //@FindBy(xpath ="//i[@class='icone-menu-prets']" )
    private WebElement loans;
    @FindBy(xpath = "//a[@data-utag-name='mortgage_loan']")
    private WebElement mortgage;
    //endregion


    public MainPage(WebDriver driver) {
        super(driver);
    }


    //region Webelements Getters

    public WebElement getLanguageIcon() {
        return languageIcon;
    }

    public WebElement getLogo() {
        return this.logo;
    }

    public WebElement getLoans() {
        return this.loans;
    }

    public WebElement getMortgage() {
        waitForElementIsVisible(mortgage, 5);
        return this.mortgage;
    }
    //endregion


    //region MainPage Methods

    public void checkPage() {
        String language = "EN";
        String url = "http://ia.ca/individuals";
        waitForElementIsVisible(getLanguageIcon(), 5);
        if (!getUrl().equals(url)&&!getText(getLanguageIcon()).equals(language)){
            clickOn(getLanguageIcon());
        }

        waitForElementIsVisible(getLoans(), 5);
        Assert.assertTrue(getLogo().isDisplayed(), "Page isn't successfully loaded");
    }

    public MortgagePage gotoMortgagePage() {
        waitAndClick(getLoans(),5);
        waitAndClick(getMortgage(),5);
        return new MortgagePage(driver);
    }
    //endregion

}

