package com.zz.splitting.service.spend;

import com.zz.splitting.entity.spend.Spend;
import com.zz.splitting.model.spend.ShareInfo;

import java.util.List;

public interface ISpendService {

    Spend createSpend(Spend spend);

    Boolean deleteSpend(Integer spendId);

    List<ShareInfo> getUserDetails(Integer eventId, Integer uid);
}
