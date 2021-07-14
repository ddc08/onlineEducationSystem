package com.atguigu.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.atguigu.commomutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.Utils.ConstantVodUtils;
import com.atguigu.vod.Utils.InitVodClient;
import com.atguigu.vod.service.VodServices;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @author ddc
 * @data 2021/3/10-14:40
 */
@Service
public class VodServicesImpl implements VodServices {

    //上传视频到阿里云
    @Override
    public String uploadVideoAly(MultipartFile file) {

        try{

        String fileName = file.getOriginalFilename();

        String title = fileName.substring(0, fileName.lastIndexOf("."));

        InputStream inputStream = file.getInputStream();

        UploadStreamRequest request = new UploadStreamRequest(
                ConstantVodUtils.ACCESS_KEY_ID,
                ConstantVodUtils.ACCESS_KEY_SECRET,
                title, fileName, inputStream);

        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);

        String videoId = null;

        if (response.isSuccess()) {
            videoId = response.getVideoId();
        }else{
            videoId = response.getVideoId();
        }

            return videoId;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //删除多个阿里云视频方法
    @Override
    public void removeMoreAlyVideo(List videoIdList) {
        try{
            //初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            //创建删除视频request对象
            DeleteVideoRequest request = new DeleteVideoRequest();

            //videoIdList值转换成1,2,3
            String videoIds = StringUtils.join(videoIdList.toArray(), ",");

            //向request设置视频id
            request.setVideoIds(videoIds);
            //调用初始化对象的方法实现删除
            client.getAcsResponse(request);
        }catch(Exception e){
            e.printStackTrace();
            throw new GuliException(20001,"删除视频失败");
        }
    }

}
