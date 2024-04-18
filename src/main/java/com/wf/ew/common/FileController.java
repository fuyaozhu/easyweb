package com.wf.ew.common;


import com.wf.ew.common.utils.FileUtils;
import com.wf.ew.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 文件上传
 */
@RestController
@RequestMapping("/file")
public class FileController {


    @PostMapping("/projectPictureUpload")
    @ResponseBody
    public Result projectPictureUpload(@RequestParam(value = "projectImg",required = true)MultipartFile file){
        //将图片上传到服务器
        if(file.isEmpty()){
            return ResultUtil.error("upload_error","项目图片不能为空");
        }
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //图片名称为uuid+图片后缀防止冲突
        String fileName = UUID.randomUUID().toString()+"."+suffix;
        String os = System.getProperty("os.name");
        //windows下的路径
        String filePath ="C:\\image\\";
        try {
            //写入图片
            Boolean writePictureflag = FileUtils.uploadFile(file.getBytes(),filePath,fileName);
            if(writePictureflag == false){
                //上传图片失败
                return ResultUtil.error("upload_error","上传项目图片失败");
            }
            //上传成功后，将可以访问的完整路径返回
            String fullImgpath = "/img/"+fileName;
            return ResultUtil.success(fullImgpath,"上传图片成功");
        } catch (Exception e) {
            e.printStackTrace();
            //上传图片失败
            return ResultUtil.error("upload_error","上传项目图片失败");
        }
    }

}
