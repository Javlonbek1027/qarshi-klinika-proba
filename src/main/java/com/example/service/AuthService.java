package com.example.service;

import com.example.dto.auth.AuthDTO;
import com.example.dto.auth.AuthResponseDTO;
import com.example.dto.auth.RegistrDTO;
import com.example.entity.EmailEntity;
import com.example.entity.Profile;
import com.example.enums.Language;
import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import com.example.exeptions.*;
import com.example.repository.EmailRepository;
import com.example.repository.ProfileRepository;
import com.example.util.JwtTokenUtil;
import com.example.util.MD5Util1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AuthService {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    private ResourceBundleService resourceService;

    public String update(AuthDTO registrDTO) {

        Profile byEmail = profileRepository.findByEmail(registrDTO.getEmail());
        if (byEmail!= null) {
            if (byEmail.getStatus().equals(ProfileStatus.NOT_ACTIVE)) {
                profileRepository.delete(byEmail);
            } else {
                AuthDTO update = new AuthDTO();
                update.setEmail(registrDTO.getEmail());
                update.setPassword(registrDTO.getPassword());
                profileRepository.updateProfilePassword(update.getPassword(),update.getEmail());

                StringBuilder sb = new StringBuilder();
                sb.append("<h1 style=\\\"text-align: center\\\">Salom Qalaysan</h1>");
                String link = String.format("<a href=\"https://kun.uz/\"> Click there</a>", JwtTokenUtil.encode(byEmail.getEmail()));
//                String link = String.format("<a href=\"http://192.168.59.235/auth/verification/email/%s\"> Click there</a>", JwtTokenUtil.encode(byEmail.getEmail()));
                sb.append(link);
                emailService.sendEmailMime(registrDTO.getEmail(), "Complite Registration", sb.toString());
                EmailEntity email=new EmailEntity();
                email.setMessage("Salom Qalaysan");
                email.setEmail(update.getEmail());
                email.setCreatedDate(LocalDateTime.now());
                emailRepository.save(email);
            }
        }



//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//            }
//        };
//        Thread thread = new Thread(runn\able);
//        thread.start();
        return "Emailga link ketdi aka tekwiring qani";

    }
    public String registration(RegistrDTO registrDTO) {
        check(registrDTO);
        Profile entity = profileRepository.findByEmail(registrDTO.getEmail());
        if (entity!= null) {
            if (entity.getStatus().equals(ProfileStatus.NOT_ACTIVE)) {
                profileRepository.delete(entity);
            } else {
                throw new PhoneAlreadyExistsException("this email already exists");
            }
        }

        Profile profileEntity = new Profile();
        profileEntity.setName(registrDTO.getName());
        profileEntity.setSurname(registrDTO.getSurname());
        profileEntity.setEmail(registrDTO.getEmail());
        profileEntity.setStatus(ProfileStatus.NOT_ACTIVE);
        profileEntity.setRole(ProfileRole.ROLE_USER);
        profileEntity.setEmail(registrDTO.getEmail());
        profileEntity.setPassword(MD5Util1.encode(registrDTO.getPassword()));
        profileRepository.save(profileEntity);

        StringBuilder sb = new StringBuilder();
        sb.append("<h1 style=\\\"text-align: center\\\">Click there for Registration</h1>");
        String link = String.format("<a href=\"http://192.168.0.112:8080/auth/verification/email/%s\"> Click there</a>", JwtTokenUtil.encode(entity.getEmail()));
        sb.append(link);//tayyor bu uzgartirmangizla
        emailService.sendEmailMime(registrDTO.getEmail(), "Complite Registration", sb.toString());
        EmailEntity email=new EmailEntity();
        email.setMessage("Salom Qalaysan");
        email.setEmail(profileEntity.getEmail());
        email.setCreatedDate(LocalDateTime.now());
        emailRepository.save(email);


//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//            }
//        };
//        Thread thread = new Thread(runn\able);
//        thread.start();
        return "Emailga link ketdi aka tekwiring qani";

    }

    public void check(RegistrDTO registrDTO){
        if(registrDTO.getName()==null||registrDTO.getName().trim().length()<=3){
            throw new AppBadRequestException("Name is wrong");
        }
        if(registrDTO.getSurname()==null||registrDTO.getSurname().trim().length()<3){
            throw new AppBadRequestException("surname is wrong");
        }
        if(registrDTO.getEmail()==null||registrDTO.getEmail().trim().length()<3){
            throw new AppBadRequestException("phone is wrong");
        }
        if(registrDTO.getMainPhotoId()==null||registrDTO.getMainPhotoId().trim().length()<3){
            throw new AppBadRequestException("password is wrong");
        }

    }

    public AuthResponseDTO login(AuthDTO dto, Language language) {

        Profile profile = profileRepository.findByEmailAndPassword(dto.getEmail(), MD5Util1.encode(dto.getPassword()));

        if (profile == null) {
            throw new ItemNotFoundException(resourceService.getMessage("credential.wrong", language.name()));
        }

        if (!profile.getStatus().equals(ProfileStatus.ACTIVE)) {
            throw new AppForbiddenException("No access");
        }

        return toResponseDTO(profile);
    }

    private AuthResponseDTO toResponseDTO(Profile profile) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setName(profile.getName());
        authResponseDTO.setSurname(profile.getSurname());
        authResponseDTO.setRole(profile.getRole());
        authResponseDTO.setToken(JwtTokenUtil.encode(profile.getEmail(), profile.getRole()));
        return authResponseDTO;
    }
    public int rand() {
        Random rand = new Random(); //instance of random class
        int upperbound = 9999;
        //generate random values from 0-24
        return rand.nextInt(upperbound);

    }
}
