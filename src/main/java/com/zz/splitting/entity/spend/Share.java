package com.zz.splitting.entity.spend;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

public class Share {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "share_amount")
    private BigDecimal shareAmount;
}
