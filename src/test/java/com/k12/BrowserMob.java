package com.k12;

import org.testng.annotations.Test;

import java.net.URISyntaxException;

import static org.testng.AssertJUnit.assertEquals;

public class BrowserMob {

    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();

    @Test
    public void formTestByIDFirefox() throws URISyntaxException {

        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Firefox");

        try {
            automatedBrowser.init();

            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");

            automatedBrowser.clickElementWithId("button_element");
            assertEquals("Button Clicked", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.populateElementWithId("text_element", "test text");
            assertEquals("Text Input Changed", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.populateElementWithId("textarea_element", "test text");
            assertEquals("Text Area Changed", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.selectOptionByTextFromSelectWithId("Option 2.1", "select_element");
            assertEquals("Select Changed", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.clickElementWithId("radio3_element");
            assertEquals("Radio Button Changed", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.clickElementWithId("checkbox2_element");
            assertEquals("Checkbox Changed", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.clickElementWithId("image_element");
            assertEquals("Image Clicked", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.clickElementWithId("div_element");
            assertEquals("Div Clicked", automatedBrowser.getTextFromElementWithId("message"));
        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void captureHarFile() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");

        try {
            automatedBrowser.init();
            automatedBrowser.captureHarFile();
            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");
        } finally {
            try {
                automatedBrowser.saveHarFile("test.har");
            } finally {
                automatedBrowser.destroy();
            }
        }
    }

    @Test
    public void captureCompleteHarFile() throws URISyntaxException {

        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");

        try {
            automatedBrowser.init();
            automatedBrowser.captureCompleteHarFile();
            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");
        } finally {
            try {
                automatedBrowser.saveHarFile("test.har");
            } finally {
                automatedBrowser.destroy();
            }
        }
    }

    @Test
    public void modifyRequests() {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Firefox");

        automatedBrowser.init();
        automatedBrowser.blockRequestTo(".*?\\.png", 201);
        automatedBrowser.blockRequestTo("https://.*?twitter\\.com/", 500);
        automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");
    }
}
