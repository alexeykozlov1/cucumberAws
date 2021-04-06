package com.k12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface AutomatedBrowser {

    DesiredCapabilities getDesiredCapabilities();

    void captureCompleteHarFile();

    WebDriver getWebDriver();

    void captureHarFile();

    void saveHarFile(String file);

    void setWebDriver(WebDriver webDriver);

    void init();

    void destroy();

    void goTo(String url);

    void clickElementWithId(String id);

    void clickElementWithId(String id, int waitTime);

    void selectOptionByTextFromSelectWithId(String optionText, String id);

    void selectOptionByTextFromSelectWithId(String optionText, String id, int waitTime);

    void populateElementWithId(String id, String text);

    void populateElementWithId(String id, String text, int waitTime);

    String getTextFromElementWithId(String id);

    String getTextFromElementWithId(String id, int waitTime);

    void clickElementWithXPath(String xpath);

    void clickElementWithXPath(String xpath, int waitTime);

    void selectOptionByTextFromSelectWithXPath(String optionText, String xpath);

    void selectOptionByTextFromSelectWithXPath(String optionText, String xpath, int waitTime);

    void populateElementWithXPath(String xpath, String text);

    void populateElementWithXPath(String xpath, String text, int waitTime);

    String getTextFromElementWithXPath(String xpath);

    String getTextFromElementWithXPath(String xpath, int waitTime);

    void clickElementWithCSSSelector(String cssSelector);

    void clickElementWithCSSSelector(String cssSelector, int waitTime);

    void selectOptionByTextFromSelectWithCSSSelector(String optionText, String cssSelector);

    void selectOptionByTextFromSelectWithCSSSelector(String optionText, String cssSelector, int waitTime);

    void populateElementWithCSSSelector(String cssSelector, String text);

    void populateElementWithCSSSelector(String cssSelector, String text, int waitTime);

    String getTextFromElementWithCSSSelector(String cssSelector);

    String getTextFromElementWithCSSSelector(String cssSelector, int waitTime);

    void clickElement(String locator);

    void clickElement(String locator, int waitTime);

    void selectOptionByTextFromSelect(String optionText, String locator);

    void selectOptionByTextFromSelect(String optionText, String locator, int waitTime);

    void populateElement(String locator, String text);

    void populateElement(String locator, String text, int waitTime);

    String getTextFromElement(String locator);

    String getTextFromElement(String locator, int waitTime);

    void blockRequestTo(String url, int responseCode);

    void alterResponseFrom(String url, int responseCode, String  responseBody);

    void maximizeWindow();
}
