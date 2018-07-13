package com.zz.splitting.entity.event;

import com.zz.splitting.model.event.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "status")
    private EventStatus status = EventStatus.OPEN;

    @Column(name = "creator_uid")
    private  Integer creatorUid;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
