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
import ru.yandex.qatools.allure.annotations.Step;

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
    @FindBy(xpath = "(//div[@class='slider-handle min-slider-handle custom'])[1]")
    private WebElement purchasePriceSlider;

    @FindBy(xpath = "//input[@id='PrixPropriete']")
    private WebElement purchasePriceField;


    @FindBy(xpath = "//label[@for='PrixPropriete']")
    private WebElement purchasePriceLabel;

    @FindBy(xpath = "(//div[@class='slider-tick custom'][@style='left: 100%;'] )[1]")
    private WebElement sliderPosition;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    private WebElement purchaseTooltip;

    @FindBy(xpath = "//button[@id='PrixProprietePlus']")
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

    @FindBy(xpath = "//span[@class='devise pct']")
    private WebElement precentageIcon;

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

    public WebElement getPurchasePriceLabel() {
        return purchasePriceLabel;
    }

    public WebElement getSliderPosition() {
        return sliderPosition;
    }

    public WebElement getPurchaseTooltip() {
        return purchaseTooltip;
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


    public WebElement getAmortizationDropdown() {
        return this.amortizationDropdown;
    }

    public WebElement getInterestRateField() {
        return this.interestRateField;
    }

    public WebElement getPrecentageIcon() {
        return this.precentageIcon;
    }

    public WebElement getCalculateButton() {
        return this.calculateButton;
    }

    public WebElement getCalculationResultField() {
        return calculationResultField;
    }
    //endregion

    @Step("Moving Purchase Price Slider")
    public void moveSlider() throws InterruptedException {
        waitAndClick(getPurchasePriceSlider(), 5);
        Actions slider = new Actions(driver);
        Action moveSliderRight = slider.clickAndHold(getPurchasePriceSlider())
                .dragAndDropBy(getPurchasePriceSlider(), 250, 0).release().build();
        Action movesliderLeft = slider.clickAndHold(getPurchasePriceSlider())
                .dragAndDropBy(getPurchasePriceSlider(), -150, 0).release().build();
        moveSliderRight.perform();
        Assert.assertTrue(getPurchasePriceField().getText().equals(getPurchaseTooltip().getText()));
        movesliderLeft.perform();
        Assert.assertTrue(getPurchasePriceField().getText().equals(getPurchaseTooltip().getText()));

    }

    @Step("Clear Purchase Price Field")
    public void clearPurchase() {
        waitAndClick(getPurchasePriceField(), 5);
        clear(getPurchasePriceField());
        waitAndClick(getPurchasePriceLabel(), 5);

    }

    @Step("Sets Purchase Price according to user data")
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

    @Step("Sets Down Payment according to user data")
    public void setDownPayment() {
        Map<Long, Integer> payment = new HashMap<Long, Integer>();
        payment.put((long) 50000, 1);
        payment.put((long) 100000, 2);
        payment.put((long) 150000, 3);
        payment.put((long) 2000000, 4);


        for (int x = payment.get(userDownPaymnet((IUser) user)); x > 0; x--) {
            waitAndClick(getDownPaymentIncreaseButton(), 5);
        }
    }

    @Step("Clear data in Purchase Price Field")
    public void clearPurchasePrice() {
        getPurchasePriceField().clear();
    }

    @Step("Sets Payment frequency according to user data")
    public void setPaymentFrerquency() {
        Map<String, Integer> paymentFrequency = new HashMap<String, Integer>();
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

    @Step("Sets user Amortization according to user data")
    public void setUserSetAmortization() {
        waitAndClick(getAmortizationDropdown(), 5);
        waitAndClick(driver.findElement(By.xpath(userSetAmortization)), 5);
    }

    @Step("Sets Interest Rate according to user data")
    public void setInterest() {
        clearAndSendKeys(getInterestRateField(), Double.toString(userInterestRate((IUser) user)));
        waitAndClick(getPrecentageIcon(), 5);
    }

    @Step("Click on clalculation button")
    public void provideCalculation() {
        waitAndClick(getCalculateButton(), 5);
    }

    @Step("Verify calculated result")
    public void checkResult() {
        waitForElementIsVisible(getCalculationResultField(), 5);
        double result = Double.parseDouble(getText(getCalculationResultField()).replace('$', ' ').trim());
        Assert.assertEquals(result, userCalculatedPayments((IUser) user));
    }


}

