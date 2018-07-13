package com.zz.splitting.service.splitResult;

import com.zz.splitting.model.JsonResult;

public interface ISplitResultOpService {

    JsonResult getSplitResults(Integer eventId, Integer uid);

    JsonResult markPaidByReceiver(Integer splitResultId);
}
