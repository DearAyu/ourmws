package com.mws.ourmws.controller;

import com.mws.ourmws.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class DownloadController {

    @Autowired
    DownloadService downloadService;

    @GetMapping("download/{fileName}")
    public void download(HttpServletResponse response, @PathVariable(value = "fileName")String fileName, HttpSession session) throws IOException {
        String accountName= (String) session.getAttribute("accountName");
        downloadService.createExcel(response,fileName,accountName);
    }

}
