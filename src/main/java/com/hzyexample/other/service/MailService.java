package com.hzyexample.other.service;


import com.hzyexample.other.vo.MailVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


/**
 * @author hzy
 * @date 2021-12-01
 */
@Service
public class MailService {
    private Logger logger = LoggerFactory.getLogger(getClass());//提供⽇志类
    @Autowired
    private JavaMailSenderImpl mailSender;//注⼊邮件⼯具类
    /**
     * 发送邮件
     */
    public MailVo sendMail() {
        try {
            MailVo mailVo = new MailVo();
            //checkMail(mailVo); //1.检测邮件
            sendMimeMail(); //2.发送邮件
            sendMimeMail(); //2.发送邮件
            return saveMail(mailVo); //3.保存邮件
        } catch (Exception e) {
            logger.error("发送邮件失败:", e);//打印错误信息

            return null;
        }
    }
    //检测邮件信息类
    private void checkMail(MailVo mailVo) {
        if (StringUtils.isEmpty(mailVo.getTo())) {
            throw new RuntimeException("邮件收信⼈不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
    }
    //构建复杂邮件信息类
    private void sendMimeMail() {
        try {
            MailVo mailVo = new MailVo();
            // MimeMessageHelper：用于填充MimeMessage助手类。
            //镜像SimpleMailMessage的简单设置器，直接将值应用到底层 MimeMessage。 允许为整个消息定义字符编码，由该助手类的所有方法自动应用
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);//true表⽰⽀持复杂类型
            mailVo.setFrom("1417243391@qq.com");//邮件发信⼈从配置项读取
            messageHelper.setFrom("hhh");//邮件发信⼈
            messageHelper.setTo("1417243391@qq.com");//邮件收信⼈
            messageHelper.setSubject("ujihjo");//邮件主题
            messageHelper.setText("yes");//邮件内容
//            if (!StringUtils.isEmpty("mailVo.getCc()")) {//抄送
//                messageHelper.setCc(mailVo.getCc().split(","));
//            }
//            if (!StringUtils.isEmpty(mailVo.getBcc())) {//密送
//                messageHelper.setCc(mailVo.getBcc().split(","));
//            }
//            if (mailVo.getMultipartFiles() != null) {//添加邮件附件
//                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
//                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
//                }
//            }
       //发送时间
                mailVo.setSentDate(new Date());
                messageHelper.setSentDate(new Date());

            mailSender.send(messageHelper.getMimeMessage());//正式发送邮件
            mailVo.setStatus("ok");
            logger.info("发送邮件成功：{}->{}", mailVo.getFrom(), mailVo.getTo());
        } catch (Exception e) {
            throw new RuntimeException(e);//发送失败
        }
    }
    //保存邮件
    private MailVo saveMail(MailVo mailVo) {
//将邮件保存到数据库..
        return mailVo;
    }
    //获取邮件发信⼈
    public String getMailSendFrom() {
        return mailSender.getJavaMailProperties().getProperty("from");
    }
}
