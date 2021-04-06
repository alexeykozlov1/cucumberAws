package com.k12;

import com.k12.pages.ticketmonster.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicketMonsterPurchase {

    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY =
            new AutomatedBrowserFactory();

    private static final int WAIT_TIME = 30;

    @Test
    public void purchaseTicketsPageObjectModel() {

        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("ChromeNoImplicitWait");

        try {

            automatedBrowser.init();

            final EventsPage eventsPage = new MainPage(automatedBrowser)
                    .openPage()
                    .buyTickets();

            final VenuePage venuePage = eventsPage
                    .selectEvent("Concert", "Rock concert of the decade");

            final CheckoutPage checkoutPage = venuePage
                    .selectVenue("Toronto : Roy Thomson Hall")
                    .book();

            final ConfirmationPage confirmationPage = checkoutPage
                    .buySectionTickets("A - Premier platinum reserve", 2)
                    .checkout("email@example.org");

            Assert.assertTrue(confirmationPage.getEmail().contains("email@example.org"));
            Assert.assertTrue(confirmationPage.getEvent().contains("Rock concert of the decade"));
            Assert.assertTrue(confirmationPage.getVenue().contains("Roy Thomson Hall"));

        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void verifyPricesPageObjectModel() {

        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("ChromeNoImplicitWait");

        try {
            automatedBrowser.init();

            final EventsPage eventsPage = new MainPage(automatedBrowser)
                    .openPage()
                    .buyTickets();

            final VenuePage venuePage = eventsPage
                    .selectEvent("Theatre", "Shane's Sock Puppets");

            final CheckoutPage checkoutPage = venuePage
                    .selectVenue("Toronto : Roy Thomson Hall")
                    .book();

            checkoutPage.selectSection("A - Premier platinum reserve");

            final float platinumAdultPrices = checkoutPage.getSectionAdultPrices();
            Assert.assertTrue(platinumAdultPrices > 10);
            Assert.assertTrue(platinumAdultPrices < 1000);

            checkoutPage.selectSection("B - Premier gold reserve");

            final float goldAdultPrices = checkoutPage.getSectionAdultPrices();
            Assert.assertTrue(goldAdultPrices > 10);
            Assert.assertTrue(goldAdultPrices < 1000);

            checkoutPage.selectSection("C - Premier silver reserve");

            final float silverAdultPrices = checkoutPage.getSectionAdultPrices();
            Assert.assertTrue(silverAdultPrices > 10);
            Assert.assertTrue(silverAdultPrices < 1000);

            checkoutPage.selectSection("D - General");

            final float generalAdultPrices = checkoutPage.getSectionAdultPrices();
            Assert.assertTrue(generalAdultPrices > 10);
            Assert.assertTrue(generalAdultPrices < 1000);
        } finally {
            automatedBrowser.destroy();
        }
    }
}
