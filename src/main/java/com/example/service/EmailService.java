package com.example.service;

import com.example.dto.profile.EmailDTO;
import com.example.entity.EmailEntity;
import com.example.repository.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepositiry;
    @Value("gulomurolov59@gmail.com")
    private String fromAccount;
    @Autowired
    private JavaMailSender javaMailSender;

    void sendEmail(String toAccount, String subject, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(fromAccount);
        msg.setTo(toAccount);
        msg.setSubject(subject);
        msg.setText(text);
        javaMailSender.send(msg);
    }

    void sendEmailMime(String toAccount, String subject, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom(fromAccount);

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(toAccount);
            helper.setSubject(subject);
            helper.setText(content);
            helper.setText(content, true);
            javaMailSender.send(mimeMessage);

            /*EmailHistory emailHistory = new EmailHistory();
            emailHistory.setEmail(toAccount);
            emailHistory.setMessage(content);
            emailHistory.setCreatedDate(LocalDateTime.now());

            emailRepository.save(emailHistory);*/
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

//    public List<EmailDTO> getByEmail(String email) {
//        List<EmailEntity> byEmail = emailRepositiry.findByEmail(email);
//        if(byEmail.isEmpty()){
//            throw new ItemNotFoundException("this email doesnot found");
//        }
//        return   ToDTO(byEmail);
//    }
//
//    public List<EmailDTO> getByData(String data) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
//
//        List<EmailEntity> byData = emailRepositiry.findByLocalDateTime(dateTime);
//        if(byData.isEmpty()){
//            throw new ItemNotFoundException("this id not found");
//        }
//        return ToDTO(byData);
//
//    }
        public List<EmailDTO> ToDTO (List < EmailEntity > emailEntities) {
            List<EmailDTO> emailDTOList = new ArrayList<>();
            for (EmailEntity emailEntity : emailEntities) {
                EmailDTO dto = new EmailDTO();
                dto.setId(emailEntity.getId());
                dto.setEmail(emailEntity.getEmail());
                dto.setMessage(emailEntity.getMessage());
                dto.setCreatedDate(emailEntity.getCreatedDate());
                emailDTOList.add(dto);
            }
            return emailDTOList;
        }
//
//    public Page<EmailDTO> getByPage(Integer page, Integer size) {
//
//        Pageable pageable= PageRequest.of(page,size);
//        Page<EmailEntity> list = emailRepositiry.findAll(pageable);
//        List<EmailEntity>content=list.getContent();
//        Long totalElement= list.getTotalElements();
//        List<EmailDTO> dtoList=new ArrayList<>();
//        for (EmailEntity email : content) {
//            EmailDTO dto=new EmailDTO();
//            dto.setEmail(email.getEmail());
//            dto.setLocalDateTime(email.getLocalDateTime());
//            dto.setMessage(email.getMessage());
//            dtoList.add(dto);
//        }
//        return new PageImpl<>(dtoList,pageable,totalElement);



}
