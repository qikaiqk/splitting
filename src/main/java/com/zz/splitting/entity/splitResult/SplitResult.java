package com.zz.splitting.entity.splitResult;

import com.zz.splitting.model.splitResult.PaymentStatus;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

public class SplitResult {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "from_uid")
    private Integer fromUid;

    @Column(name = "to_uid")
    private Integer toUid;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "status")
    private PaymentStatus status = PaymentStatus.TOBEPAID;

}
