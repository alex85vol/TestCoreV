package com.corevalue.test.apps;

/**
 * Created by ovo on 24.01.2017.
 */
public interface IWebAppSources {

    String getBrowserName();

    String getDriverPath();

    long getImplicitTimeOut();

    long getExplicitTimeOut();

    String getLanguage();


    String getLoggerstrategy();

    String getMainPageUrl();

}
