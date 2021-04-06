package com.k12.pages.ticketmonster;

import com.k12.AutomatedBrowser;
import com.k12.pages.BasePage;

public class VenuePage extends BasePage {

    private static final String VENUE_DROP_DOWN_LIST = "venueSelector";
    private static final String BOOK_BUTTON = "bookButton";

    public VenuePage(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    public VenuePage selectVenue(final String venue) {
        automatedBrowser.selectOptionByTextFromSelect(venue, VENUE_DROP_DOWN_LIST, WAIT_TIME);
        return this;
    }

    public CheckoutPage book() {
        automatedBrowser.clickElement(BOOK_BUTTON, WAIT_TIME);
        return new CheckoutPage(automatedBrowser);
    }
}
