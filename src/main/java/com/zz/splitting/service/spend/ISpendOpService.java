package com.zz.splitting.service.spend;

import com.zz.splitting.model.JsonResult;

import java.math.BigDecimal;
import java.util.List;

public interface ISpendOpService {

    JsonResult createSpend(
            String spendDesc,
            BigDecimal amount,
            Integer prepayUid,
            List<Integer> shareUids);

    JsonResult deleteSpendByPrepayUser(Integer spendId);

    JsonResult getUserDetails(Integer eventId, Integer uid);

    JsonResult getUserSummary(Integer eventId, Integer uid);

}
