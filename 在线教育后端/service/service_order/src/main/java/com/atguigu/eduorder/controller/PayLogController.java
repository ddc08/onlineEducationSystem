package com.atguigu.eduorder.controller;


import com.atguigu.commomutils.R;
import com.atguigu.eduorder.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/eduorder/paylog")
//@CrossOrigin
public class PayLogController {
    @Autowired
    private PayLogService payLogService;

    //生成微信支付二维码
    @GetMapping("createNative/{orderNo}")
    public R createrNative(@PathVariable String orderNo){
        Map map = payLogService.createNative(orderNo);
        System.out.println("************返回二维码map集合"+map);
        return R.ok().data(map);
    }

    //查询订单支付状态
    @GetMapping("queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo){
        Map<String,String> map = payLogService.queryPayStatus(orderNo);
        System.out.println("**************查询订单状态map集合"+map);
        if(map == null){
            return R.error().message("支付出错了");
        }
        if (map.get("trade_state").equals("SUCCESS")){
            //添加记录到支付表，更新订单表订单状态
            payLogService.updateOrderStatus(map);
            return R.ok().message("支付成功");
        }
        return R.ok().code(25000).message("支付中");
    }
}

