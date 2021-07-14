package com.atguigu.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author ddc
 * @data 2021/2/25-14:01
 */
@Data
public class DemoData {

    //设置excel表头名称
    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生名称",index = 1)
    private String sname;

}
