package com.zz.splitting.service.splitResult;

import com.zz.splitting.entity.splitResult.SplitResult;

import java.util.List;

public interface ISplitResultService {

    List<SplitResult> getSplitResults(Integer eventId, Integer uid);

    SplitResult updatePaymentStatus(Integer splitResultId);
}
