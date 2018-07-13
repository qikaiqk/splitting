package com.zz.splitting.repo.spend;

import com.zz.splitting.entity.spend.Spend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendRepo extends JpaRepository<Spend, Integer> {
}
