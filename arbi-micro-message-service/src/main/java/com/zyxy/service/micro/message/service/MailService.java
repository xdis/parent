package com.zyxy.service.micro.message.service;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.MailRecordWithBLOBs;
import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.dto.MailInfoDTO.Attachment;
import com.zyxy.common.dto.MailInfoDTO.InlineRes;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.util.ArrayUtil;
import com.zyxy.common.util.ImageUtil;

/**
 * 
 * @author tanquan
 *
 */
@Service
public class MailService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired  
    private JavaMailSender sender;  
    @Autowired(required=false)
    private MicroFileService mFileService;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private MailRecordService mailRecordService;
    
    @Value("${spring.mail.username}")  
    private String from;  
    
    public String send(MailInfoDTO info) {
        MailRecordWithBLOBs record = new MailRecordWithBLOBs();
        record.setId(sequenceService.getCommonID());
        record.setBuzzId(info.getBuzzId());
        record.setCc(ArrayUtil.join(info.getCc()));
        record.setContent(info.getContent());
        record.setCreateTime(new Date());
        record.setStauts(0); // 发送中
        record.setSubjuct(info.getSubject());
        record.setMailTo(ArrayUtil.join(info.getTo()));
        record.setUserId(info.getUserId());
        String attachmentInfo = "";
        if (info.getAttachmentIDs() != null) {
            attachmentInfo += ArrayUtil.join(info.getAttachmentIDs());
        }
        if (info.getAttachments() != null) {
            for (Attachment f : info.getAttachments()) {
                if (f != null) {
                    attachmentInfo += "," + f.getFileName();
                }
            }
        }
        record.setAttachment(attachmentInfo);
        mailRecordService.insertSelective(record);
        Boolean ret = false;
        if (info.getIsSimmple()) {
            ret = this.sendSimpleMail(info);
        } else {
            ret = this.sendMultipartMail(info);
        }
        MailRecordWithBLOBs up = new MailRecordWithBLOBs();
        up.setId(record.getId());
        if (ret) {
            up.setStauts(1);
        } else {
            up.setStauts(2);
        }
        mailRecordService.updateByPrimaryKeySelective(up);
        return ret ? record.getId() : null;
    }
    
    /**
     * 发送纯文本简单邮件 
     * @param info
     * @return
     */
    private Boolean sendSimpleMail(MailInfoDTO info){  
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom(from);  
        message.setTo(info.getTo()); 
        message.setSubject(info.getSubject());  
        message.setText(info.getContent());  
        if (info.getCc() != null) {
            message.setCc(info.getCc());
        }
        try {  
            sender.send(message);  
            logger.info("简单邮件已经发送"); 
            return true;
        } catch (Exception e) {  
            logger.error("发送简单邮件时发生异常", e);  
        }  
        return false;
    }  
    
    /**
     * 发送富文本邮件 
     * @param info
     * @return
     */
    private Boolean sendMultipartMail(MailInfoDTO info){  
        MimeMessage message = sender.createMimeMessage();  
        try {  
            //true表示需要创建一个multipart message  
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  
            helper.setFrom(from);
            helper.setTo(info.getTo()); 
            helper.setSubject(info.getSubject());  
            helper.setText(info.getContent(), true);  
            if (info.getCc() != null) {
                helper.setCc(info.getCc());
            }
            // 添加附件
            if (info.getAttachments() != null) {
                for (Attachment f : info.getAttachments()) {
                    ByteArrayResource file = new ByteArrayResource(f.getBytes());  
                    String fileName = f.getFileName();  
                    helper.addAttachment(fileName, file); 
                }
            }
            if (info.getAttachmentIDs() != null) {
                for (String fileId : info.getAttachmentIDs()) {
                    ResponseEntity<byte[]> resp = mFileService.downloadFile(fileId);
                    String fileName = "";
                    List<String> names = resp.getHeaders().get("Content-Disposition");
                    if (names != null && !names.isEmpty()) {
                        fileName = names.get(0);
                        fileName = fileName.substring(fileName.indexOf("attachment;fileName="));
                    }
                    helper.addAttachment(fileName, new ByteArrayResource(resp.getBody()));  
                }
            }
            // 添加图片等静态资源
            if (info.getImages() != null && info.getImages().length > 0) {
                for (InlineRes img : info.getImages()) {
                    helper.addInline(img.getRscId(), 
                                    new ByteArrayResource(
                                            ImageUtil.convertBase64Byte(
                                                    img.getImgBase64())));
                }
            }
            
            sender.send(message);  
            logger.info("富文本邮件已经发送");  
            return true;
        } catch (MessagingException e) {  
            logger.error("发送富文本邮件异常", e);  
        }
        
        return false;
    }  
    
}
