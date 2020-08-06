package com.controller.design.api;

import com.controller.design.constant.StatusCode;
import com.controller.design.requestentity.Event;
import com.controller.design.responseentity.Response;
import com.controller.design.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.controller.design.constant.ControllerDesignConstant.*;

@RestController
@RequestMapping(EVENT_CONTROLLER_URI)
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(value = NEW_EVENTS_URI, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Response<String>> newEvent(@RequestBody Event event, @RequestHeader(name = OS_DETAILS) String osDetails) {
        Response successResponse = null;
        Response errorResponse = null;
        if (eventService.newEvent(event)) {
            successResponse = new Response(StatusCode.SUCCESS.toString(), SUCCESS_RESPONSE_MESSAGE);
            return new ResponseEntity<>(successResponse,HttpStatus.CREATED);
        } else {
            errorResponse = new Response(StatusCode.ERROR.toString(), ERROR_RESPONSE_MESSAGE);
            return new ResponseEntity<>(errorResponse,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = GET_EVENTS)
    public @ResponseBody ResponseEntity<Response<List<Event>>> getEvents(@RequestHeader(name = OS_DETAILS) String osDetails) {
        Response successResponse = null;
        Response errorResponse = null;
        if (eventService.getEvents().size() != 0) {
            successResponse = new Response(StatusCode.SUCCESS.toString(), eventService.getEvents());
            return new ResponseEntity<>(successResponse, HttpStatus.FOUND);
        } else if (eventService.getEvents().size() == 0){
            errorResponse = new Response(StatusCode.NO_RECORD.toString(), NO_RECORD_MESSAGE);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }else{
            errorResponse = new Response(StatusCode.ERROR.toString(), ERROR_RESPONSE_MESSAGE);
            return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = GET_EVENT)
    public @ResponseBody ResponseEntity<Response<Event>> getEvent(@RequestParam("subscription_id") String subscription_id,
                                                                        @RequestHeader(name = OS_DETAILS) String osDetails) {
        Response successResponse = null;
        Response errorResponse = null;
        if (eventService.getEvents().size() != 0) {
            List<Event> eventList=eventService.getEvents().stream().filter(e->e.getSubscription_id().equals(subscription_id)).collect(Collectors.toList());
            if(eventList.size()!=0 && (subscription_id!=null || subscription_id.trim()!="") ) {
                successResponse = new Response(StatusCode.SUCCESS.toString(), eventList);
                return new ResponseEntity<>(successResponse, HttpStatus.FOUND);
            }else if((subscription_id==null || subscription_id.trim()=="")){
                errorResponse = new Response(StatusCode.ERROR.toString(), ID_BLANK);
                return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
            } else{
                errorResponse = new Response(StatusCode.ERROR.toString(), NO_RECORD_MESSAGE);
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        }else if((subscription_id==null || subscription_id.trim()=="")){
            errorResponse = new Response(StatusCode.ERROR.toString(), ID_BLANK);
            return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
        } else if (eventService.getEvents().size() == 0){
            errorResponse = new Response(StatusCode.NO_RECORD.toString(), NO_RECORD_MESSAGE);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }else{
            errorResponse = new Response(StatusCode.ERROR.toString(), ERROR_RESPONSE_MESSAGE);
            return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
