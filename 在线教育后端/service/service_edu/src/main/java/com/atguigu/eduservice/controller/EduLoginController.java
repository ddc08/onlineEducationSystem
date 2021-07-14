package com.atguigu.eduservice.controller;

import com.atguigu.commomutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author ddc
 * @data 2021/2/1-15:17
 */
@RestController
@RequestMapping("/eduservice/user")
//@CrossOrigin
public class EduLoginController {

    //login
    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    //info
    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
