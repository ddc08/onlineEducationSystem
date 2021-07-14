package com.atguigu.eduservice.client;

import com.atguigu.commomutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ddc
 * @data 2021/3/15-14:16
 */
@Component
public class VodFileDegradeFeignClient implements VodClient{
    //出错之后执行
    @Override
    public R removeAlyVideo(String id) {

        return R.error().message("删除视频出错");
    }

    @Override
    public R deleteBach(List<String> videoIdList) {

        return R.error().message("删除多个视频出错");
    }
}
