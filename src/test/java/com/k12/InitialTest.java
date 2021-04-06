package com.k12;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InitialTest {

    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY
            = new AutomatedBrowserFactory();

    private String browser;
    @Test
    public void openURL() {
        final ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://ipublicmarketing.s3.amazonaws.com/form.html");
        chromeDriver.quit();
    }


}
