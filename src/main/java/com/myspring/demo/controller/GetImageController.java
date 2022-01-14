package com.myspring.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@RestController
public class GetImageController {

    private String imgPath = "d:\\codes\\ima.jpg";

    private InputStream getImgInputStream() throws FileNotFoundException {
        return new FileInputStream(new File(imgPath));
    }

    @GetMapping("/img-response")
    public void getImage(HttpServletResponse resp) throws IOException {
        final InputStream in = getImgInputStream();
        resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, resp.getOutputStream());
    }
}
