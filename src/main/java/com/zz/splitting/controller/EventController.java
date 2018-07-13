package com.zz.splitting.controller;

import com.zz.splitting.model.JsonResult;
import com.zz.splitting.model.event.EventInfo;
import com.zz.splitting.service.event.IEventOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/internal/event")
public class EventController {

    @Autowired
    IEventOpService eventOpService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    JsonResult createEvent(@RequestBody EventInfo eventInfo) {
        return eventOpService.createEventWithUsers(eventInfo.getEventName(), eventInfo.getUserIds());
    }
}
