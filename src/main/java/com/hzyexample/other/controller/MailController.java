package com.hzyexample.other.controller;


import com.hzyexample.other.service.MailService;
import com.hzyexample.other.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hzy
 * @date 2021-12-01
 */
@Controller
public class MailController {
    @Autowired
    private MailService mailService;

/**
 * 发送邮件
 */
    @PostMapping("/mail/send")
    public MailVo sendMail( ) {
       // mailVo.setMultipartFiles(files);
        return mailService.sendMail();//发送邮件和附件
    }
}
