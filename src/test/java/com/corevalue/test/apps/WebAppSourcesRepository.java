package com.corevalue.test.apps;

/**
 * Created by ovo on 24.01.2017.
 */
public final class WebAppSourcesRepository {

    private WebAppSourcesRepository(){}

    public static WebAppSources getDefault() {return getChromeBrowser();}
    /***
     * Here we have repository for browser. We can implement methods for every supported browser if we need them.
     * Impolementation based on previously created WebAppSources class where we used pattern builder
     */
    // Application for Chrome Browser
    public static WebAppSources getChromeBrowser() {
        return WebAppSources.get()
                .setBrowserName("Chrome")
                .setDriverPath("src\\test\\resources\\chromedriver.exe")
                .setBrowserPath("")
                .setDefaultProfile("")
                .setImplicitTimeOut(5L)
                .setExplicitTimeOut(5L)
                .setLanguage("")
                .setLoggerStrategy("")
                .setMainPageUrl("http://www.ia.ca")
                .build();


    }

}
