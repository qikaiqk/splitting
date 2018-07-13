package com.zz.splitting.service.event;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEventUserRelService {

    Boolean addEventUserRel(Integer eventId, List<Integer> userId);
}
