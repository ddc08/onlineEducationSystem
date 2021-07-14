package com.atguigu.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;

import java.util.List;

/**
 * @author ddc
 * @data 2021/3/10-10:45
 */
public class YestVod {
    public static void main(String[] args) throws ClientException {
        //1.根据视频id播放视频地址
        //创建初始化对象
        DefaultAcsClient client = InitObject.initVodClient("LTAI4GG78hFeBJpFEynNcDNh","NP3bYu3FUz6RA1f2HzLKniI4BU5hY6");
        //拆功能键获取视频地址request和response
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();

        //向request对象里面设置id
        request.setVideoId("7ac4d7239ab546c689e9b2550ec4aaf3");
        //调用初始化对象里面的方法，传递request，获取数据
        response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");


    }
}
