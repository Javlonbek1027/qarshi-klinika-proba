package com.example.controller;

import com.example.dto.auth.AuthDTO;
import com.example.dto.auth.AuthResponseDTO;
import com.example.dto.auth.RegistrDTO;
import com.example.enums.Language;
import com.example.service.AuthService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO dto,
                                   @RequestHeader(name = "Accept-Language",defaultValue = "EN") Language language){
        log.info("Authorization: {} " ,dto);
        log.debug("Debug: {} " ,dto);
        log.warn("Warning: {} " ,dto);
        log.error("Error: {} " ,dto);
        log.trace("trace: {} " ,dto);
        AuthResponseDTO authResponseDTO = authService.login(dto,language);
        return ResponseEntity.ok(authResponseDTO);
    }
    @PostMapping("/registration")//✔
    public ResponseEntity<?> registration(@RequestBody RegistrDTO registrDTO){
        log.info("Registration:{}"+registrDTO);

        String result=authService.registration(registrDTO);
        return ResponseEntity.ok(result);
    }
}
