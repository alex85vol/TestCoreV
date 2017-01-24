package com.corevalue.test.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by ovo on 24.01.2017.
 */
public abstract class MainPage {

    public static enum ChangeLanguageFields {
        FRENCH("EN"),
        ENGLISH("FR");
        //
        private String field;


        private ChangeLanguageFields(String field) {
            this.field = field;
        }


        @Override
        public String toString() {
            return field;
        }
    }

        //Fields
        protected WebDriver driver;

    protected MainPage(WebDriver driver) {
        this.driver = driver;
    }

    }

