package com.controller.design.service.serviceimpl;

import com.controller.design.requestentity.Event;
import com.controller.design.service.EventService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventServiceImplementation implements EventService {

    public List<Event> events= new ArrayList<>();

    @Override
    public boolean newEvent(Event event){
       return events.add(event);
    }

    @Override
    public List<Event> getEvents () {
        return events;
    }
}
