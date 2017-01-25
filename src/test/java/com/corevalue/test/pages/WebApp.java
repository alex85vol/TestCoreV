package com.corevalue.test.pages;

import com.corevalue.test.apps.WebAppSources;
import com.corevalue.test.apps.WebAppSourcesRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovo on 24.01.2017.
 */
public class WebApp {

    //Fields
    private static volatile WebApp instance;
    private WebDriver driver;
    private WebAppSources webAppSources;


    private interface IBrowser {
        WebDriver getBrowser(WebApp webApp);
    }

    private static class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser(WebApp webApp) {
            System.setProperty("webdriver.chrome.driver",
                    webApp.webAppSources.getDriverPath());
            return new ChromeDriver();
        }
    }

    public static enum Browsers {
        DEFAULT_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
        CHROME_TEMPORARY("ChromeTemporary", new ChromeTemporary());

        //
        private String browserName;
        private IBrowser browser;

        private Browsers(String browserName, IBrowser browser) {
            this.browserName = browserName;
            this.browser = browser;
        }

        public WebDriver runBrowser(WebApp webApp) {

            return browser.getBrowser(webApp);
        }

        @Override
        public String toString() {
            return browserName;
        }
    }

    private WebApp(WebAppSources webAppSources) {
        this.webAppSources = webAppSources;
    }

    public static WebApp get() {
        return get(null);
    }

    public static WebApp get(WebAppSources webAppSources) {
        if (instance == null) {
            synchronized (WebApp.class) {
                if (instance == null) {
                    if (webAppSources == null) {
                        webAppSources = WebAppSourcesRepository.getDefault();
                    }
                    instance = new WebApp(webAppSources);
                    instance.init();
                }
            }
        }
        return instance;
    }

    public static void remove() {
        if (instance != null) {
            instance.quit();
        }
        instance = null;
    }

    public void init() {
        initWebDriver();
    }

    public MainPage load() {
        driver.get(webAppSources.getMainPageUrl());
        return new MainPage(driver);
    }


    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    private void initWebDriver() {
        Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
        for (Browsers browser : Browsers.values()) {
            if (browser.toString().toLowerCase()
                    .contains(webAppSources.getBrowserName().toLowerCase())) {
                currentBrowser = browser;
                break;
            }
        }
        driver = currentBrowser.runBrowser(this);
        driver.manage().timeouts()
                .implicitlyWait(webAppSources.getImplicitTimeOut(), TimeUnit.SECONDS);
    }
}
