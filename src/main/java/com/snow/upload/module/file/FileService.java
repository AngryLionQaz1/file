package com.snow.upload.module.file;

import com.snow.upload.common.bean.Config;
import com.snow.upload.common.bean.Result;
import com.snow.upload.common.bean.Tips;
import com.snow.upload.common.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class FileService {

    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private Config config;

    /**不支持的-文件类型*/
    private static List<String> falseType=new ArrayList<>();



    public Result uploadFile(MultipartFile file) {
      if (checkType(getType(file)))return Result.fail(Tips.TYPE_FALSE.msg);
      String path=fileUtils.saveFile(Paths.get(config.getFilePath()),file);
      if (path==null)return Result.fail();
      String url="http://"+config.getFileHost()+":"+config.getFilePort()+"/"+config.getFileUrl()+"/"+path;
      return Result.success(url,path);
    }


    /**判断该类型是否支持上传*/
    private boolean checkType(String type){
        if (falseType.size()==0)initType();
        return falseType.contains(type);
    }

    /**类型初始化*/
    private void initType(){
        String[] strings=config.getFileType().split(",");
        Arrays.stream(strings).forEach(i->falseType.add(i));
    }



    /**获取文件类型*/
    private String getType(MultipartFile file){
        String fileName = file.getOriginalFilename();
        //获取文件类型
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }


    public Result path() {
        return Result.success("http://"+config.getFileHost()+":"+config.getFilePort()+"/"+config.getFileUrl()+"/");
    }
}
