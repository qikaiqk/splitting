package com.zz.splitting.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class CurrentTime {
    public static Timestamp getCurrentTimestamp() {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        return new Timestamp(now.getTime());
    }
}
