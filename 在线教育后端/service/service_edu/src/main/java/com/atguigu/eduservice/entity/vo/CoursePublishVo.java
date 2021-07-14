package com.atguigu.eduservice.entity.vo;

import lombok.Data;

/**
 * @author ddc
 * @data 2021/3/9-17:31
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
