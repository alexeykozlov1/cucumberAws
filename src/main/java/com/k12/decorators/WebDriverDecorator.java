package com.k12.decorators;

import com.k12.decoratorbase.AutomatedBrowserBase;
import com.k12.utils.SimpleBy;
import com.k12.utils.impl.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDecorator extends AutomatedBrowserBase {
    private WebDriver webDriver;
    private int defaultExplicitWaitTime;

    public WebDriverDecorator() {
    }

    @Override
    public void setDefaultExplicitWaitTime(final int waitTime) {
        defaultExplicitWaitTime = waitTime;
    }


    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void setWebDriver(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void destroy() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public void goTo(final String url) {
        webDriver.get(url);
    }

    @Override
    public void clickElementWithId(final String id) {
        if (defaultExplicitWaitTime <= 0) {
            webDriver.findElement(By.id(id)).click();
        } else {
            clickElementWithId(id, defaultExplicitWaitTime);
        }
    }

    @Override
    public void clickElementWithId(final String id, final int waitTime) {
        if (waitTime <= 0) {
            clickElementWithId(id);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.id(id)))).click();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(final String optionText, final String selectId) {
        new Select(webDriver.findElement(By.id(selectId))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithId(final String optionText, final String id, final int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithId(id, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.id(id))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void populateElementWithId(final String id, final String text) {
        webDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Override
    public void populateElementWithId(final String id, final String text,
                                      final int waitTime) {
        if (waitTime <= 0) {
            populateElementWithId(id, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.id(id)))).sendKeys(text);
        }
    }

    @Override
    public String getTextFromElementWithId(final String id) {
        return webDriver.findElement(By.id(id)).getText();
    }

    @Override
    public String getTextFromElementWithId(final String id, final int
            waitTime) {
        if (waitTime <= 0) {
            return getTextFromElementWithId(id);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            return wait.until(ExpectedConditions.presenceOfElementLocated((By.id(id)))).getText();
        }
    }

    @Override
    public void clickElementWithName(final String name) {
        webDriver.findElement(By.name(name)).click();
    }

    @Override
    public void clickElementWithName(final String name, final int waitTime) {
        if (waitTime <= 0) {
            clickElementWithName(name);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(By.name(name))).click();
        }
    }

    @Override
    public void clickElementWithXPath(final String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void clickElementWithXPath(final String xpath, final int waitTime) {
        if (waitTime <= 0) {
            clickElementWithXPath(xpath);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath)))).click();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithName(final String optionText, final String name) {
        new Select(webDriver.findElement(By.name(name))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithName(final String optionText, final String name, final int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithName(name, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable(By.name(name)))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(final String optionText, final String xpath) {
        new Select(webDriver.findElement(By.xpath(xpath))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(final String
                                                              optionText, final String xpath, final int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithXPath(xpath, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void populateElementWithName(final String name, final String
            text) {
        webDriver.findElement(By.name(name)).sendKeys(text);
    }

    @Override
    public void populateElementWithName(final String name, final String
            text, final int waitTime) {
        if (waitTime <= 0) {
            populateElementWithName(name, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.name(name)))).sendKeys(text);
        }
    }

    @Override
    public void populateElementWithXPath(final String xpath, final String
            text) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Override
    public void populateElementWithXPath(final String xpath, final String
            text, final int waitTime) {
        if (waitTime <= 0) {
            populateElementWithXPath(xpath, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath)))).sendKeys(text);
        }
    }

    @Override
    public String getTextFromElementWithXPath(final String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    @Override
    public String getTextFromElementWithXPath(final String xpath, final int
            waitTime) {
        if (waitTime <= 0) {
            return getTextFromElementWithXPath(xpath);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath)))).getText();
        }
    }

    @Override
    public void clickElementWithCSSSelector(final String cssSelector) {
        webDriver.findElement(By.cssSelector(cssSelector)).click();
    }

    @Override
    public void clickElementWithCSSSelector(String css, final int waitTime) {
        if (waitTime <= 0) {
            clickElementWithCSSSelector(css);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(css)))).click();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSSSelector(final String optionText, final String cssSelector) {
        new
                Select(webDriver.findElement(By.cssSelector(cssSelector))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSSSelector(final String optionText, final String css, final int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithCSSSelector(css, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(css))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void populateElementWithCSSSelector(final String cssSelector,
                                               final String text) {
        webDriver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    @Override
    public void populateElementWithCSSSelector(String css, final String text, final int waitTime) {
        if (waitTime <= 0) {
            populateElementWithCSSSelector(css, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(css)))).sendKeys(text);
        }
    }

    @Override
    public String getTextFromElementWithCSSSelector(final String cssSelector) {
        return webDriver.findElement(By.cssSelector(cssSelector)).getText();
    }

    @Override
    public String getTextFromElementWithCSSSelector(String css, final int waitTime) {
        if (waitTime <= 0) {
            return getTextFromElementWithCSSSelector(css);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            return wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(css)))).getText();
        }
    }
    private static final SimpleBy SIMPLE_BY = new SimpleByImpl();

    @Override
    public void clickElement(final String locator) {
        clickElement(locator, defaultExplicitWaitTime);
    }

    @Override
    public void clickElement(final String locator, final int waitTime) {
        SIMPLE_BY.getElement(
                getWebDriver(),
                locator,
                waitTime,
                by -> ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    @Override
    public void selectOptionByTextFromSelect(final String optionText, final String locator) {
        selectOptionByTextFromSelect(optionText, locator, defaultExplicitWaitTime);
    }

    @Override
    public void selectOptionByTextFromSelect(final String optionText, final String locator, final int waitTime) {
        new Select(SIMPLE_BY.getElement(
                getWebDriver(),
                locator,
                waitTime,
                by -> ExpectedConditions.elementToBeClickable(by)))
                .selectByVisibleText(optionText);
    }

    @Override
    public void populateElement(final String locator, final String text) {
        populateElement(locator, text, defaultExplicitWaitTime);
    }

    @Override
    public void populateElement(final String locator, final String text, final int waitTime) {
        SIMPLE_BY.getElement(
                getWebDriver(),
                locator,
                waitTime,
                by -> ExpectedConditions.elementToBeClickable(by))
                .sendKeys(text);
    }

    @Override
    public String getTextFromElement(final String locator) {
        return getTextFromElement(locator, defaultExplicitWaitTime);
    }

    @Override
    public String getTextFromElement(final String locator, final int waitTime) {
        return SIMPLE_BY.getElement(
                getWebDriver(),
                locator,
                waitTime,
                by -> ExpectedConditions.presenceOfElementLocated(by))
                .getText();
    }

    @Override
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }
}