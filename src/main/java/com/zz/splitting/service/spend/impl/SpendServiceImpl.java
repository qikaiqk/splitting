package com.zz.splitting.service.spend.impl;

import com.zz.splitting.entity.spend.Spend;
import com.zz.splitting.model.spend.ShareInfo;
import com.zz.splitting.service.spend.ISpendService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendServiceImpl implements ISpendService {
    @Override
    public Spend createSpend(Spend spend) {
        return null;
    }

    @Override
    public Boolean deleteSpend(Integer spendId) {
        return null;
    }

    @Override
    public List<ShareInfo> getUserDetails(Integer eventId, Integer uid) {
        return null;
    }
}
