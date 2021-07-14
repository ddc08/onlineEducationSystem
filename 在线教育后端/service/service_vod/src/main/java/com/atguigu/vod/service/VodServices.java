package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ddc
 * @data 2021/3/10-14:40
 */
public interface VodServices {
    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    //删除多个阿里云视频方法
    void removeMoreAlyVideo(List videoIdList);
}
