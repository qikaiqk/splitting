package com.zz.splitting.service.event.impl;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.entity.event.Event;
import com.zz.splitting.repo.event.EventRepo;
import com.zz.splitting.service.event.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements IEventService {


    @Autowired
    EventRepo eventRepo;

    @Override
    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public Event addEventUser(Integer eventId, Integer userId) {
        return null;
    }

    @Override
    public Boolean deleteEventUser(Integer eventId, Integer userId) {
        return null;
    }

    @Override
    public List<User> getEventUsers(Integer eventId) {
        return null;
    }
}
