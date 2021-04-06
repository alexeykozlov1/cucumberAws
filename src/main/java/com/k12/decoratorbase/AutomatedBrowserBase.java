package com.k12.decoratorbase;

import com.k12.AutomatedBrowser;
import com.k12.AutomatedBrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class AutomatedBrowserBase implements AutomatedBrowser {
    private AutomatedBrowser automatedBrowser;
    private Map<String, String> aliases = new HashMap<>();
    static private final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY
            = new AutomatedBrowserFactory();

    public AutomatedBrowserBase() {
    }

    public AutomatedBrowserBase(final AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    public AutomatedBrowser getAutomatedBrowser() {
        return automatedBrowser;
    }

    @Override
    public WebDriver getWebDriver() {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getWebDriver();
        }
        return null;
    }

    @Override
    public void setWebDriver(final WebDriver webDriver) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().setWebDriver(webDriver);
        }
    }

    @Override
    public void init() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().init();
        }
    }

    @Override
    public void destroy() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().destroy();
        }
    }
    @And("^I open the URL \"([^\"]*)\"$")
    @Override
    public void goTo(String url) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().goTo(aliases.getOrDefault(url, url));
        }
    }

    @Given("^I set the following aliases:$")
    public void setAliases(Map<String, String> aliases) {
        this.aliases.putAll(aliases);
    }

    @And("^I click the \\w+(?:\\s+\\w+)* with the id \"([^\"]*)\"$")
    @Override
    public void clickElementWithId(final String id) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithId(id);
        }
    }
    @And("^I click the \\w+(?:\\s+\\w+)* with the id \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void clickElementWithId(final String id, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithId(id, waitTime);
        }
    }

    @And("^I set the default explicit wait time to \"(\\d+)\" seconds?$")
    @Override
    public void setDefaultExplicitWaitTime(int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().setDefaultExplicitWaitTime(waitTime);
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the id \"([^\"]*)\"$")
    @Override
    public void selectOptionByTextFromSelectWithId(String optionText, String
            id) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithId(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(id, id));
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the id \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void selectOptionByTextFromSelectWithId(final String optionText, final String id, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithId(aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(id, id));
        }
    }

    @And("^I populate the \\w+(?:\\s+\\w+)* with the id \"([^\"]*)\" with the text \"([^\"]*)\"$")
    @Override
    public void populateElementWithId(final String id, final String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithId(aliases.getOrDefault(id, id),
                    aliases.getOrDefault(text, text));
        }
    }

    @And("^I populate the \\w+(?:\\s+\\w+)* with the id \"([^\"]*)\" with the text \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void populateElementWithId(final String id, final String text, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithId(
                    aliases.getOrDefault(id, id),
                    aliases.getOrDefault(text, text),
                    waitTime);
        }
    }

    @Override
    public String getTextFromElementWithId(final String id) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithId(id);
        }
        return null;
    }

    @Override
    public String getTextFromElementWithId(final String id, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithId(id, waitTime);
        }
        return null;
    }

    @And("^I click the \\w+(?:\\s+\\w+)* with the xpath \"([^\"]*)\"$")
    @Override
    public void clickElementWithXPath(final String xpath) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithXPath(xpath);
        }
    }

    @And("^I click the \\w+(?:\\s+\\w+)* with the name \"([^\"]*)\"$")
    @Override
    public void clickElementWithName(final String name) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithName(name);
        }
    }

    @And("^I click the \\w+(?:\\s+\\w+)* with the name \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void clickElementWithName(final String name, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithName(name, waitTime);
        }
    }



    @And("^I click the \\w+(?:\\s+\\w+)* with the xpath \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void clickElementWithXPath(final String xpath, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithXPath(xpath, waitTime);
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the name \"([^\"]*)\"$")
    @Override
    public void selectOptionByTextFromSelectWithName(final String optionText, final String name) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithName(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(name, name));
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the name \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void selectOptionByTextFromSelectWithName(final String optionText, final String name, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithName(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(name, name),
                    waitTime);
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the xpath \"([^\"]*)\"$")
    @Override
    public void selectOptionByTextFromSelectWithXPath(final String optionText, final String xpath) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(xpath, xpath));
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the xpath \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void selectOptionByTextFromSelectWithXPath(final String optionText, final String xpath, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(xpath, xpath),
                    waitTime);
        }
    }

    @And("^I populate the \\w+(?:\\s+\\w+)* with the name \"([^\"]*)\" with the text \"([^\"]*)\"$")
    @Override
    public void populateElementWithName(final String name, final String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithName(
                    aliases.getOrDefault(name, name),
                    aliases.getOrDefault(text, text));
        }
    }

    @And("^I populate the \\w+(?:\\s+\\w+)* with the name \"([^\"]*)\" with the text \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void populateElementWithName(final String name, final String text, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithName(
                    aliases.getOrDefault(name, name),
                    aliases.getOrDefault(text, text),
                    waitTime);
        }
    }


    @And("^I populate the \\w+(?:\\s+\\w+)* with the xpath \"([^\"]*)\" with the text \"([^\"]*)\"$")
    @Override
    public void populateElementWithXPath(final String xpath, final String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithXPath(
                    aliases.getOrDefault(xpath, xpath),
                    aliases.getOrDefault(text, text));
        }
    }


    @And("^I populate the \\w+(?:\\s+\\w+)* with the xpath \"([^\"]*)\" with the text \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void populateElementWithXPath(final String xpath, final String text, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithXPath(
                    aliases.getOrDefault(xpath, xpath),
                    aliases.getOrDefault(text, text),
                    waitTime);
        }
    }

    @Override
    public String getTextFromElementWithXPath(final String xpath) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithXPath(xpath);
        }
        return null;
    }

    @Override
    public String getTextFromElementWithXPath(final String xpath, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithXPath(xpath,
                    waitTime);
        }
        return null;
    }

    @And("^I click the \\w+(?:\\s+\\w+)* with the css selector \"([^\"]*)\"$")
    @Override
    public void clickElementWithCSSSelector(final String cssSelector) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithCSSSelector(cssSelector);
        }
    }

    @And("^I click the \\w+(?:\\s+\\w+)* with the css selector \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void clickElementWithCSSSelector(final String cssSelector, final
    int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithCSSSelector(cssSelector, waitTime);
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the css selector \"([^\"]*)\"$")
    @Override
    public void selectOptionByTextFromSelectWithCSSSelector(final String optionText, final String cssSelector) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithCSSSelector(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(cssSelector, cssSelector));
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \\w+(?:\\s+\\w+)* with the css selector \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void selectOptionByTextFromSelectWithCSSSelector(final String optionText, final String cssSelector, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithCSSSelector(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(cssSelector, cssSelector),
                    waitTime);
        }
    }

    @And("^I populate the \\w+(?:\\s+\\w+)* with the css selector \"([^\"]*)\" with the text \"([^\"]*)\"$")
    @Override
    public void populateElementWithCSSSelector(final String cssSelector, final String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithCSSSelector(
                    aliases.getOrDefault(cssSelector, cssSelector),
                    aliases.getOrDefault(text, text));
        }
    }

    @And("^I populate the \\w+(?:\\s+\\w+)* with the css selector \"([^\"]*)\" with the text \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void populateElementWithCSSSelector(final String cssSelector, final String text, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithCSSSelector(
                    aliases.getOrDefault(cssSelector, cssSelector),
                    aliases.getOrDefault(text, text),
                    waitTime);
        }
    }


    @Override
    public String getTextFromElementWithCSSSelector(final String cssSelector) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithCSSSelector(cssSelector);
        }
        return null;
    }

    @Override
    public String getTextFromElementWithCSSSelector(final String cssSelector, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithCSSSelector(cssSelector, waitTime);
        }
        return null;
    }

    @And("^I click the \"([^\"]*)\" \\w+(?:\\s+\\w+)*$")
    @Override
    public void clickElement(final String locator) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElement(aliases.getOrDefault(locator, locator));
        }
    }

    @And("^I click the \"([^\"]*)\" \\w+(?:\\s+\\w+)* waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void clickElement(final String locator, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElement(locator, waitTime);
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \"([^\"]*)\" \\w+(?:\\s+\\w+)*$")
    @Override
    public void selectOptionByTextFromSelect(final String optionText, final String locator) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelect(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(locator, locator));
        }
    }

    @And("^I select the option \"([^\"]*)\" from the \"([^\"]*)\" \\w+(?:\\s+\\w+)* waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void selectOptionByTextFromSelect(final String optionText, final String locator, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelect(
                    aliases.getOrDefault(optionText, optionText),
                    aliases.getOrDefault(locator, locator),
                    waitTime);
        }
    }

    @And("^I populate the \"([^\"]*)\" \\w+(?:\\s+\\w+)* with the text \"([^\"]*)\"$")
    @Override
    public void populateElement(final String locator, final String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElement(
                    aliases.getOrDefault(locator, locator),
                    aliases.getOrDefault(text, text));
        }
    }

    @And("^I populate the \"([^\"]*)\" \\w+(?:\\s+\\w+)* with the text \"([^\"]*)\" waiting up to \"(\\d+)\" seconds?$")
    @Override
    public void populateElement(final String locator, final String text, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElement(
                    aliases.getOrDefault(locator, locator),
                    aliases.getOrDefault(text, text),
                    waitTime);
        }
    }

    @Override
    public String getTextFromElement(final String locator) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElement(locator);
        }
        return null;
    }

    @Override
    public String getTextFromElement(final String locator, final int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElement(locator, waitTime);
        }
        return null;
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getDesiredCapabilities();
        }

        return new DesiredCapabilities();
    }

    @And("^I capture the HAR file$")
    @Override
    public void captureHarFile() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().captureHarFile();
        }
    }

    @And("^I save the HAR file to \"([^\"]*)\"$")
    @Override
    public void saveHarFile(final String file) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().saveHarFile(file);
        }
    }

    @And("^I capture the complete HAR file$")
    @Override
    public void captureCompleteHarFile() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().captureCompleteHarFile();
        }
    }

    @And("^I block the request to \"([^\"]*)\" returning the HTTP code \"\\d+\"$")
    @Override
    public void blockRequestTo(final String url, final int responseCode) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().blockRequestTo(url, responseCode);
        }
    }

    @And("^I alter the response fron \"([^\"]*)\" returning the HTTP code \"\\d+\" and the response body:$")
    @Override
    public void alterResponseFrom(final String url, final int responseCode, final String responseBody) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().alterResponseFrom(url, responseCode, responseBody);
        }
    }

    @And("^I maximize the window$")
    @Override
    public void maximizeWindow() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().maximizeWindow();
        }
    }

    @Given("^I open the browser \"([^\"]*)\"$")
    public void openBrowser(String browser) {
        automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser(browser);
        automatedBrowser.init();
    }

    @Given("^I close the browser$")
    public void closeBrowser() {
        if (automatedBrowser != null) {
            automatedBrowser.destroy();
            automatedBrowser = null;
        }
    }


}