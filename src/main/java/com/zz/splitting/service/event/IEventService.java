package com.zz.splitting.service.event;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.entity.event.Event;

import java.util.List;

public interface IEventService {

    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event addEventUser(Integer eventId, Integer userId);

    Boolean deleteEventUser(Integer eventId, Integer userId);

    List<User> getEventUsers(Integer eventId);
}
