package com.snow.upload.module.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Api(tags = "文件上传")
@RestController
public class FileController {


    @Autowired
    private FileService service;



    @GetMapping("path")
    @ApiOperation(value = "获取地址")
    public ResponseEntity path(){
        return ResponseEntity.ok(service.path());
    }

    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public ResponseEntity uploadFle(@RequestParam MultipartFile file){
        return ResponseEntity.ok(service.uploadFile(file));
    }













}
