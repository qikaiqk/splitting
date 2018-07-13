package com.zz.splitting.service.spend.impl;

import com.zz.splitting.model.JsonResult;
import com.zz.splitting.service.spend.ISpendOpService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SpendOpServiceImpl implements ISpendOpService {
    @Override
    public JsonResult createSpend(String spendDesc, BigDecimal amount, Integer prepayUid, List<Integer> shareUids) {
        return null;
    }

    @Override
    public JsonResult deleteSpendByPrepayUser(Integer spendId) {
        return null;
    }

    @Override
    public JsonResult getUserDetails(Integer eventId, Integer uid) {
        return null;
    }

    @Override
    public JsonResult getUserSummary(Integer eventId, Integer uid) {
        return null;
    }
}
