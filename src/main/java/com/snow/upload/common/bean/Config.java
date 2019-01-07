package com.snow.upload.common.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix ="config" )
public class Config {


    /**端口号*/
    private Integer filePort=8080;
    /**本地文件地址*/
    private String  filePath;
    /**IP地址*/
    private String  fileHost;
    /**请求地址*/
    private String  fileUrl="/upload/**";
    /**设置不能上传的文件类型*/
    private String  fileType="php,java,jsp";











}
