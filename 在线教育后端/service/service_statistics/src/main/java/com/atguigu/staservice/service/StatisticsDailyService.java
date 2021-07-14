package com.atguigu.staservice.service;

import com.atguigu.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-05-18
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    //统计某一天注册人数
    void registerCount(String day);

    //图表显示，返回两部分数据吗，日期，数量
    Map<String, Object> getShowData(String type, String begin, String end);
}
