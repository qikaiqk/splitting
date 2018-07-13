package com.zz.splitting.service.event;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.model.JsonResult;

import java.util.List;

public interface IEventOpService {

    JsonResult createEventWithUsers(String eventName, List<Integer> userIds);

//    JsonResult updateEventName(String eventName);

    JsonResult generateEventQrCode(Integer eventId);

    JsonResult addEventByQrScan(String qrCode, Integer userId);

    JsonResult addEventUserByCreator(Integer eventId, Integer userId);

    JsonResult addEventUsersByCreator(Integer eventId, List<Integer> userIds);

    JsonResult deleteEventUserByCreator(Integer eventId, Integer userId);

    JsonResult deleteEventUsersByCreator(Integer eventId, List<Integer> userIds);

    JsonResult getEventUsers(Integer eventId);
}
