package com.mignon.spring.controller;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.entity.dto.FileDTO;
import com.mignon.spring.entity.po.UserPO;
import com.mignon.spring.service.FileService;
import com.mignon.spring.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/file",method = {
        RequestMethod.GET
})
@Logger
@RequiredArgsConstructor
public class FileController {


    private final FileService fileService;


    @GetMapping("f1")
    @ResponseBody
    public UserPO getFile(){
        UserPO userPO = new UserPO();
        userPO.setName("xisheng");
        userPO.setId(2);
        return userPO;
    }

    @GetMapping(value = "/f2",params = {
            "name","age"
    })
    @ResponseBody
    public void getFile2(@RequestBody String name, Integer age){
        System.out.println(name+age);
    }



    @GetMapping("jquery")
    public ResponseEntity<Resource> downloadStaticFile() throws IOException {
        Resource resource = new ClassPathResource("js/jquery-3.7.1.js");

        Path path = Paths.get(resource.getURI());
        String contentType = Files.probeContentType(path);
        // 自动检测文件类型
        if (contentType == null) {
            contentType = "application/octet-stream";
            // 默认MIME类型
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/newfile")
    public Result<Boolean>  newFile(@Validated @RequestBody FileDTO fileDTO,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error ->
                errorMessages.append(error.getDefaultMessage()).append("; ")
            );
            return Result.failed("参数校验失败: " + errorMessages);
        }
        return Result.success(fileService.setFile(fileDTO));
    }
}
