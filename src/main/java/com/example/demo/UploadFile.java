package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class UploadFile {

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file, @RequestParam("name") String name ) throws Exception{
        File dir = new File("/mydata/nginx/html");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(new File(dir.getAbsolutePath() + File.separator + name));
        return "上传完成: " + name;
    }





}
