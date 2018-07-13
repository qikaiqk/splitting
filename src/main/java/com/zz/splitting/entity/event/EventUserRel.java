package com.zz.splitting.entity.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "event_user_rel")
@NoArgsConstructor
@AllArgsConstructor
public class EventUserRel {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "uid")
    private Integer uid;
}
