package com.corevalue.test.pages;


import com.corevalue.test.data.IUser;
import com.corevalue.test.data.UserRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ovo on 24.01.2017.
 */
public class CalculatorPage extends WebToolPage {

    //region User Data
    private Object user = UserRepository.getStandardUser();

    private long userPurchasePrice(IUser user) {
        return user.getPurchasePrice();
    }

    private long userDownPaymnet(IUser user) {
        return user.getDownPayment();
    }

    private static int userAmortization(IUser user) {
        return user.getAmortization();
    }

    private String userPaymentFrequency(IUser user) {
        return user.getPaymentFrequency();
    }

    private double userInterestRate(IUser user) {
        return user.getInterestRate();
    }

    private double userCalculatedPayments(IUser user) {

        return user.getCalculatedPayments();
    }
    //endregion

    private String userSetAmortization = "//select[@id='Amortissement']/option[@value='"
            + Integer.toString(userAmortization((IUser) user)) + "']";


    //region Webelements field
    //@FindBy(xpath = "(//div[@class='slider-selection tick-slider-selection'])[1]")
    //@FindBy(xpath = "(//div[@class='slider-tick custom in-selection'])[1]")
    @FindBy(xpath = "//div[@class='slider-handle min-slider-handle custom'])[1]")
    private WebElement purchasePriceSlider;
    @FindBy(xpath = "//input[@id='PrixPropriete']")
    private WebElement purchasePriceField;
    @FindBy(xpath = "//div[@class='tooltip-inner']")
    private WebElement purchaseTooltip;
    @FindBy(xpath = "//button[@class='PrixProprietePlus']")
    private WebElement purchasePriceDecreaseButton;
    @FindBy(xpath = "//button[@class='PrixProprietePlus']")
    private WebElement purchasePriceIncreaseButton;
    @FindBy(xpath = "//button[@id='MiseDeFondPlus']")
    private WebElement downPaymentIncreaseButton;
    @FindBy(xpath = "//input[@id='MiseDeFond']")
    private WebElement downPaymentField;
    @FindBy(xpath = "//select[@id='Amortissement']")
    private WebElement amortizationDropdown;
    @FindBy(xpath = "//select[@id='FrequenceVersement']")
    private WebElement paymentFrequencyDropDown;
    @FindBy(xpath = "//input[@id='TauxInteret']")
    private WebElement interestRateField;
    @FindBy(xpath = "//button[@id='btn_calculer']")
    private WebElement calculateButton;
    @FindBy(xpath = "//span[@id='paiement-resultats']")
    private WebElement calculationResultField;


//endregion


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    //region Webelements Getters
    public WebElement getPurchasePriceSlider() {
        return this.purchasePriceSlider;
    }

    public WebElement getPurchasePriceField() {
        return this.purchasePriceField;
    }

    public WebElement getPurchaseTooltip() {
        return purchaseTooltip;
    }

    public WebElement getPurchasePriceDecreaseButton() {
        return purchasePriceDecreaseButton;
    }

    public WebElement getPurchasePriceIncreaseButton() {
        return this.purchasePriceIncreaseButton;
    }


    public WebElement getDownPaymentIncreaseButton() {
        return this.downPaymentIncreaseButton;
    }

    public WebElement getDownPaymentField() {
        return this.downPaymentField;
    }


    public WebElement getPaymentFrequencyDropDown() {
        return paymentFrequencyDropDown;
    }

    public WebElement getCalculationResultField() {
        return calculationResultField;
    }

    public WebElement getAmortizationDropdown() {
        return this.amortizationDropdown;
    }

    public WebElement getInterestRateField() {
        return this.interestRateField;
    }

    public WebElement getCalculateButton() {
        return this.calculateButton;
    }
    //endregion

    public void moveSlider() {
        waitAndClick(getPurchasePriceSlider(), 5);
        Actions slider = new Actions(driver);
        Action moveSlider = slider.clickAndHold(getPurchasePriceSlider())
                .moveToElement(getPurchasePriceIncreaseButton()).release(getPurchasePriceIncreaseButton()).build();
        Assert.assertTrue(getPurchasePriceField().getText().equals(getPurchaseTooltip().getText()));
    }

    public void setPurchasePrice() {
        Map<Long, Integer> price = new HashMap<Long, Integer>();
        price.put((long) 250000, 1);
        price.put((long) 500000, 2);
        price.put((long) 750000, 3);
        price.put((long) 1000000, 4);


        for (int x = price.get(userPurchasePrice((IUser) user)); x > 0; x--) {
            waitAndClick(getPurchasePriceIncreaseButton(), 5);
        }


    }

    public void clearPurchasePrice() {
        getPurchasePriceField().clear();
    }

    public void setPaymentFrerquency() {
        Map<String, Integer> paymentFrequency = new HashMap<String,Integer>();
        paymentFrequency.put("Monthly", 12);
        paymentFrequency.put("Biweekly", 26);
        paymentFrequency.put("Biweekly +", 24);
        paymentFrequency.put("Weekly", 52);
        paymentFrequency.put("Weekly +", 48);

        String userPaymentFrequency = "//select[@id='FrequenceVersement']/option[@value='"
                + Integer.toString(paymentFrequency.get(userPaymentFrequency((IUser) user))) + "']";
        WebElement setUserPaymentFrequency = driver.findElement(By.xpath(userPaymentFrequency));
        waitAndClick(setUserPaymentFrequency, 5);




    }

    public void setUserSetAmortization(){
        waitAndClick(getAmortizationDropdown());
        waitAndClick(driver.findElement(By.xpath(userSetAmortization)));
    }

}

