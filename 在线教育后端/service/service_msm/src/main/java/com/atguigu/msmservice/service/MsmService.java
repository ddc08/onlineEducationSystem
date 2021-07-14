package com.atguigu.msmservice.service;

import java.util.Map;

/**
 * @author ddc
 * @data 2021/5/11-10:16
 */
public interface MsmService {

    boolean send(Map<String, Object> param, String phone);
}
