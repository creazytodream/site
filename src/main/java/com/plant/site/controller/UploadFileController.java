package com.plant.site.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-01-15 09:31
 * @version:1.0
 **/
@Slf4j
@Controller
@RequestMapping("upload")
public class UploadFileController extends BaseController {
    @GetMapping(value = "testUploadFiles")
    @ResponseBody
    public void handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    String uploadFilePath = file.getOriginalFilename();
                    log.info("uploadFlePath:{}", uploadFilePath);
                    // 截取上传文件的文件名
                    String uploadFileName = uploadFilePath
                            .substring(uploadFilePath.lastIndexOf('\\') + 1,
                                    uploadFilePath.indexOf('.'));
                    log.info("uploadFileName:{}", uploadFileName);
                    // 截取上传文件的后缀
                    String uploadFileSuffix = uploadFilePath.substring(
                            uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
                    log.info("uploadFileSuffix:{}", uploadFileSuffix);
                    stream = new BufferedOutputStream(new FileOutputStream(new File(
                            ".//uploadFiles//" + uploadFileName + "." + uploadFileSuffix)));
                    byte[] bytes = file.getBytes();
                    stream.write(bytes, 0, bytes.length);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                log.info("上传文件为空");
            }
        }
        log.info("文件接受成功了");
    }
}
