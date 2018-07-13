package com.zz.splitting.repo.event;

import com.zz.splitting.entity.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Integer> {
}
