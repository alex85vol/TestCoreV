package com.corevalue.test.tests;

import com.corevalue.test.apps.WebAppSources;
import com.corevalue.test.apps.WebAppSourcesRepository;
import com.corevalue.test.data.IUser;
import com.corevalue.test.data.UserRepository;
import com.corevalue.test.pages.CalculatorPage;
import com.corevalue.test.pages.MainPage;
import com.corevalue.test.pages.MortgagePage;
import com.corevalue.test.pages.WebApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ovo on 25.01.2017.
 */
public class NavigationTest {

    @AfterClass
    public void afterClass() {
        WebApp.remove();
    }

    @DataProvider
    public Object[][] standardUser() {
        return new Object[][]{
                {WebAppSourcesRepository.getChromeBrowser(), UserRepository.getStandardUser()}
        };
    }


    @Test(dataProvider = "standardUser")
    public void checkCalculation(WebAppSources webAppSources, IUser user) throws Exception{
        MainPage mainPage = WebApp.get(webAppSources).load();
        mainPage.checkPage();
        MortgagePage mortgagePage = mainPage.gotoMortgagePage();
        CalculatorPage calculatorPage = mortgagePage.gotoCalculator();
        calculatorPage.setPurchasePrice();
        Thread.sleep(2000);
        calculatorPage.setDownPayment();
        Thread.sleep(2000);
        calculatorPage.setUserSetAmortization();
        Thread.sleep(2000);
        calculatorPage.setPaymentFrerquency();
        Thread.sleep(2000);
        calculatorPage.setInterest();
        Thread.sleep(2000);
        calculatorPage.provideCalculation();
        Thread.sleep(10000);
    }



}
