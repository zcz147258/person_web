package com.it.person.Controller;

import com.it.person.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class UploadController {

    @Autowired
    UploadService uploadService;
    @PostMapping("/upload")
    public Map<String,Object> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("username") String username){
        return uploadService.Upload(file,username);
    }
}
