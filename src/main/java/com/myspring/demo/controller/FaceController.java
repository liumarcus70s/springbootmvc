package com.myspring.demo.controller;

import com.myspring.demo.face.FaceUtils;
import com.myspring.demo.face.ImgUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *  //TODO 描述
 *
 *  @author: Ray.ma
 *  @Data: 2021-01-28 11:30
 *  @Version: 1.0.0
 */

@Slf4j
@RestController
@RequestMapping
public class FaceController {

    private String imgPath = "d:\\codes\\imb.jpg";
    /**
     *  获取图片中人脸个数
     *
     *  @param base64Images base64图片，不包含逗号之前的部分
     *  @return
     */

    @PostMapping("checkFaceNumber")
    public int checkFaceNumber(String base64Images) {


        base64Images = ImgUtils.readImage(imgPath);
        return FaceUtils.checkFaceNo(base64Images);
    }


    /**
     *  提取最大脸
     *
     *  @param response
     *  @param base64Images
     *  @throws IOException
     */
    @PostMapping("extractMaxFace")
    public void extractMaxFace(HttpServletResponse response, String base64Images) throws IOException {
        base64Images = ImgUtils.readImage(imgPath);
        log.error(base64Images);
        int indexOf = base64Images.indexOf(",");
        if (indexOf > 0) {
            base64Images = base64Images.substring(indexOf + 1);
        }
        response.setContentType("application/octet-stream");
        PrintWriter writer = response.getWriter();
        base64Images = FaceUtils.extractMaxFace(base64Images);
        if (!StringUtils.hasLength(base64Images)) {
            throw new RuntimeException("没有人脸");
        }
        writer.write("data:image/png;base64,".concat(base64Images));
        //writer.write(base64Images);
        writer.flush();
    }

    /**
     *  标记脸
     *
     *  @param response
     *  @param base64Images
     *  @throws IOException
     */
    @PostMapping("markFace")
    public void markFace(HttpServletResponse response, String base64Images) throws IOException {
        int indexOf = base64Images.indexOf(",");
        if (indexOf > 0) {
            base64Images = base64Images.substring(indexOf + 1);
        }
        response.setContentType("application/octet-stream");
        PrintWriter writer = response.getWriter();
        base64Images = FaceUtils.markFace(base64Images);
        writer.write("data:image/png;base64,".concat(base64Images));
        writer.flush();
    }
}
