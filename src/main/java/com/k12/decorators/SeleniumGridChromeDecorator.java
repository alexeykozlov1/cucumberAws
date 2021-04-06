package com.k12.decorators;

import com.k12.AutomatedBrowser;
import com.k12.decoratorbase.AutomatedBrowserBase;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumGridChromeDecorator extends AutomatedBrowserBase {

    public SeleniumGridChromeDecorator(final AutomatedBrowser  automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();

        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
//        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        options.merge(caps);
        return caps;
    }
}
