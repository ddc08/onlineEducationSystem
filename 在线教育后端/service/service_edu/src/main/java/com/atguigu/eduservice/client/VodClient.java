package com.atguigu.eduservice.client;

import com.atguigu.commomutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ddc
 * @data 2021/3/15-11:22
 */
@FeignClient(name = "service-vod",fallback = VodFileDegradeFeignClient.class)
@Component
public interface VodClient {
    //定义调用的方法路径
    @DeleteMapping("/eduvod/video/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

    //定义删除多个视频的方法
    @DeleteMapping("/eduvod/video/delete-bach")
    public R deleteBach(@RequestParam("videoIdList") List<String> videoIdList);
}
