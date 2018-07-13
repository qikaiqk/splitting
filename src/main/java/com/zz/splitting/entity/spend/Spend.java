package com.zz.splitting.entity.spend;

import com.zz.splitting.model.spend.SpendStatus;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Spend {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "desc")
    private String desc;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "prepay_uid")
    private Integer prepayUid;

    @Column(name = "status")
    private SpendStatus status = SpendStatus.ACTIVE;
}
