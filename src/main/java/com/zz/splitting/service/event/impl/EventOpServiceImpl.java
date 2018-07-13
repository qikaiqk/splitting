package com.zz.splitting.service.event.impl;

import com.zz.splitting.CommonCode;
import com.zz.splitting.entity.account.User;
import com.zz.splitting.entity.event.Event;
import com.zz.splitting.model.JsonResult;
import com.zz.splitting.model.event.EventInfo;
import com.zz.splitting.model.event.EventStatus;
import com.zz.splitting.service.event.IEventOpService;
import com.zz.splitting.service.event.IEventService;
import com.zz.splitting.service.event.IEventUserRelService;
import com.zz.splitting.util.CurrentTime;
import com.zz.splitting.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class EventOpServiceImpl implements IEventOpService {

    @Autowired
    IEventService eventService;

    @Autowired
    IEventUserRelService eventUserRelService;

    @Override
    public JsonResult createEventWithUsers(String eventName, List<Integer> userIds) {

        User createUser = UserHolder.getUser();
        Timestamp createdAt = CurrentTime.getCurrentTimestamp();
        Event newEvent = Event
                    .builder()
                    .eventName(eventName)
                    .createdAt(createdAt)
                    .creatorUid(createUser.getId())
                    .status(EventStatus.IN_PROGRESS)
                    .build();
        Event savedEvent = eventService.createEvent(newEvent);

        EventInfo data = EventInfo
                        .builder()
                        .id(savedEvent.getId())
                        .eventName(eventName)
                        .status(savedEvent.getStatus())
                        .userIds(userIds)
                        .createdAt(createdAt)
                        .build();

        Boolean isRelAdded = eventUserRelService.addEventUserRel(savedEvent.getId(), userIds);

        if (isRelAdded) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SUCC)
                    .msg("Event 创建成功")
                    .data(data)
                    .build();
        }
        return JsonResult
                .builder()
                .code(CommonCode.SYS_ERR)
                .msg("Event 创建不成功")
                .build();
    }

//    @Override
//    public JsonResult updateEventName(String eventName) {
//        return null;
//    }

    @Override
    public JsonResult generateEventQrCode(Integer eventId) {
        return null;
    }

    @Override
    public JsonResult addEventByQrScan(String qrCode, Integer userId) {
        return null;
    }

    @Override
    public JsonResult addEventUserByCreator(Integer eventId, Integer userId) {
        return null;
    }

    @Override
    public JsonResult addEventUsersByCreator(Integer eventId, List<Integer> userIds) {
        return null;
    }

    @Override
    public JsonResult deleteEventUserByCreator(Integer eventId, Integer userId) {
        return null;
    }

    @Override
    public JsonResult deleteEventUsersByCreator(Integer eventId, List<Integer> userIds) {
        return null;
    }

    @Override
    public JsonResult getEventUsers(Integer eventId) {
        return null;
    }
}
