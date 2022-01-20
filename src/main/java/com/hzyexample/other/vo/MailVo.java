package com.hzyexample.other.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author hzy
 * @date 2021-12-01
 */
@Data
//通过邮件信息类(MailVo) 来保存发送邮件时的邮件主题、邮件内容等信息 ：
public class MailVo {
    private String id;//邮件id
    private String from;//邮件发送⼈
    private String to;//邮件接收⼈（多个邮箱则⽤逗号","隔开）
    private String subject;//邮件主题
    private String text;//邮件内容
    private Date sentDate;//发送时间
    private String cc;//抄送（多个邮箱则⽤逗号","隔开）
    private String bcc;//密送（多个邮箱则⽤逗号","隔开）
    private String status;//状态
    private String error;//报错信息
    @JsonIgnore
    private MultipartFile[] multipartFiles;//邮件附件
}
