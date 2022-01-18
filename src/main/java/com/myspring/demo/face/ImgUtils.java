package com.myspring.demo.face;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImgUtils {

    public static String readImage(String path) {
        byte[] fileByte = null;
        try{
            File file = new File(path);
            fileByte = Files.readAllBytes(file.toPath());
        } catch (IOException e){
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(fileByte);
    }
}
