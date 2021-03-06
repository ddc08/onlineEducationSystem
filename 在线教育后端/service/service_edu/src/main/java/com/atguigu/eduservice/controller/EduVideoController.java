package com.atguigu.eduservice.controller;


import com.atguigu.commomutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-02-26
 */
@RestController
@RequestMapping("/eduservice/video")
//@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;

    //注入vodClient
    private VodClient vodClient;

    //添加小结
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小结
    //TODO后米娜这个方法需要完善：删除小结时，同时把里面视频删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){

        //根据小结id获取视频id，调用方法删除
        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        //判断小结是否有视频id
        if (!StringUtils.isEmpty(videoSourceId)){
            R result = vodClient.removeAlyVideo(videoSourceId);
            if (result.getCode() == 20001){
                throw new GuliException(20001,"删除视频失败，熔断器...");
            }
        }

        videoService.removeById(id);
        return R.ok();
    }

    //根据id查询小节


    //修改小结

}

