package com.k12.decorators;

import com.k12.AutomatedBrowser;
import com.k12.decoratorbase.AutomatedBrowserBase;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackEdgeDecorator extends AutomatedBrowserBase {

    public BrowserStackEdgeDecorator(final AutomatedBrowser  automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities caps = getAutomatedBrowser().getDesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Edge");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium_version", "3.7.0");
        return caps;
    }
}