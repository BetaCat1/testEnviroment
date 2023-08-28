package com.test.controller;

import com.test.downupload.ZipDownloadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DownloadController {


    private final ZipDownloadUtil zipDownloadUtil;
    @GetMapping(value = "/downloadZip")
    public  void getTicketsRepaired(HttpServletResponse response){
        File file = new File("C:\\Users\\ZWD\\Desktop\\文件下载测试\\测试文件夹");
        String source = "C:\\Users\\ZWD\\Desktop\\文件下载测试\\测试文件夹";
        List<File> list = new ArrayList<File>();
        list.add(file);

        ZipDownloadUtil.zip(source,response);

    }
}
