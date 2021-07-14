package com.atguigu.staservice.schedule;

import com.atguigu.staservice.service.StatisticsDailyService;
import com.atguigu.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ddc
 * @data 2021/5/19-9:16
 */
@Component
public class ScheduledTask {

    @Autowired
    private StatisticsDailyService staService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        //获取上一天的日期
        staService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }
}
