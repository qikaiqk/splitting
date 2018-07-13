package com.zz.splitting.service.splitResult.impl;

import com.zz.splitting.model.JsonResult;
import com.zz.splitting.service.splitResult.ISplitResultOpService;
import org.springframework.stereotype.Service;

@Service
public class SplitResultOpServiceImpl implements ISplitResultOpService {
    @Override
    public JsonResult getSplitResults(Integer eventId, Integer uid) {
        return null;
    }

    @Override
    public JsonResult markPaidByReceiver(Integer splitResultId) {
        return null;
    }
}
