package com.k12.pages.ticketmonster;

import com.k12.AutomatedBrowser;
import com.k12.pages.BasePage;

public class EventsPage extends BasePage {

    public EventsPage(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    public VenuePage selectEvent(final String category, final String event)
    {
        automatedBrowser.clickElement(category, WAIT_TIME);
        automatedBrowser.clickElement(event, WAIT_TIME);
        return new VenuePage(automatedBrowser);
    }
}