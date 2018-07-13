package com.zz.splitting.model.event;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class EventInfo {
    private Integer id;
    private String eventName;
    private EventStatus status;
    private List<Integer> userIds;
    private Timestamp createdAt;
}
