package com.atguigu.oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ddc
 * @data 2021/2/22-20:12
 */

public interface OssService {
    //上传头像到oss
    String uploadFileAvatar(MultipartFile file);
}
