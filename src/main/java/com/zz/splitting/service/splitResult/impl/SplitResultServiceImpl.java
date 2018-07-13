package com.zz.splitting.service.splitResult.impl;

import com.zz.splitting.entity.splitResult.SplitResult;
import com.zz.splitting.service.splitResult.ISplitResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SplitResultServiceImpl implements ISplitResultService {
    @Override
    public List<SplitResult> getSplitResults(Integer eventId, Integer uid) {
        return null;
    }

    @Override
    public SplitResult updatePaymentStatus(Integer splitResultId) {
        return null;
    }
}
