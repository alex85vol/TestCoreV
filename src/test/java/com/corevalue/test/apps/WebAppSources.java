package com.corevalue.test.apps;

/**
 * Created by ovo on 24.01.2017.
 */
interface IBrowserName {
    IDriverPath setBrowserName(String browserName);
}

interface IDriverPath {
    IBrowserPath setDriverPath(String driverPath);
}

interface IBrowserPath {
    IDefaultProfile setBrowserPath(String browserPath);
}

interface IDefaultProfile {
    IImplicitTimeOut setDefaultProfile(String defaultProfile);
}


interface IImplicitTimeOut {
    IExplicitTimeOut setImplicitTimeOut(long implicitTimeOut);
}

interface IExplicitTimeOut {
    ILanguage setExplicitTimeOut(long explicitTimeOut);
}

interface ILanguage {
    ILoggerStrategy setLanguage(String language);
}

interface ILoggerStrategy {
    IMainPageUrl setLoggerStrategy(String loggerStrategy);
}

interface IMainPageUrl {
    IBuild setMainPageUrl(String mainPageUrl);
}


interface IBuild {
    WebAppSources build();
}


    public class WebAppSources implements IBrowserName, IDriverPath,
            IBrowserPath, IDefaultProfile,
            IImplicitTimeOut, IExplicitTimeOut, ILanguage,
            ILoggerStrategy, IMainPageUrl, IBuild, IWebAppSources {


        // Browser Data
        private String browserName;
        private String driverPath;
        private String browserPath;
        private String defaultProfile;
        // Implicit and Explicit Waits
        private long implicitTimeOut;
        private long explicitTimeOut;
        // Localization Strategy
        private String language;
        // Logger Strategy
        private String loggerStrategy;
        // URLs
        private String mainPageUrl;



        private WebAppSources() {
        }

        public static IBrowserName get() {
            return new WebAppSources();
        }

        //setters
        public IDriverPath setBrowserName(String browserName) {
            this.browserName = browserName;
            return this;
        }

        public IBrowserPath setDriverPath(String driverPath) {
            this.driverPath = driverPath;
            return this;

        }

        public IDefaultProfile setBrowserPath(String browserPath){
            this.browserPath = browserPath;
            return this;
        }

        public IImplicitTimeOut setDefaultProfile(String defaultProfile) {
            this.defaultProfile = defaultProfile;
            return this;

        }

        public IExplicitTimeOut setImplicitTimeOut(long implicitTimeOut) {
            this.implicitTimeOut = implicitTimeOut;
            return this;
        }

        public ILanguage setExplicitTimeOut(long explicitTimeOut) {
            this.explicitTimeOut = explicitTimeOut;
            return this;
        }

        public ILoggerStrategy setLanguage(String language) {
            this.language = language;
            return this;
        }
        public IMainPageUrl setLoggerStrategy(String loggerStrategy) {
            this.loggerStrategy = loggerStrategy;
            return this;
        }

        public IBuild setMainPageUrl(String mainPageUrl) {
            this.mainPageUrl = mainPageUrl;
            return this;
        }

        public WebAppSources build() {
            return this;
        }

        //getters

        public String getBrowserName() {
            return browserName;
        }

        public String getDriverPath() {
            return driverPath;
        }

        public String getBrowserPath() { return browserPath;}

        public String getDefaultProfile() { return defaultProfile;}

        public long getImplicitTimeOut() {
            return implicitTimeOut;
        }

        public long getExplicitTimeOut() {
            return explicitTimeOut;
        }

        public String getLanguage() {
            return language;
        }

        public String getLoggerstrategy() { return loggerStrategy; }

        public String getMainPageUrl() {
            return mainPageUrl;
        }


    }

