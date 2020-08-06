package com.controller.design.service;

import com.controller.design.requestentity.Event;

import java.util.List;

public interface EventService {

    public boolean newEvent(Event event);
    public List<Event> getEvents ();
}
