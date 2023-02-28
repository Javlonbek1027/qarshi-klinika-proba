package com.example.controller;

import com.example.dto.auth.AuthDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.mapper.UpdateProfileNameAndEmail;
import com.example.service.ProfileService;
import com.example.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/admin/create")//✔
    public HttpStatus createProfileByAdmin(@RequestBody ProfileDTO dto){
        int result =  profileService.createProfile( dto);
        return result==1?HttpStatus.CREATED:HttpStatus.I_AM_A_TEAPOT;
    }
    @GetMapping("/info/{id}")//✔
    public ResponseEntity<ProfileDTO> myInfo(@PathVariable Integer id){
        return ResponseEntity.ok(profileService.getMyInfo(id));
    }
    @GetMapping("/update/password")//✔
    public ResponseEntity<AuthDTO> updatePassword() {
        AuthDTO profile = profileService.forUpdateDTO(SpringSecurityUtil.getCurrentUserId());
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/update/password/result")//✔
    public String updateProfilePassword(@RequestBody AuthDTO profileDTO){
        return  profileService.updateProfilePassword(SpringSecurityUtil.getCurrentEntity().getEmail(), profileDTO.getPassword());
    }
    @GetMapping("/update/password/detail/{profileId}")//✔
    public ResponseEntity<UpdateProfileNameAndEmail> updateDetail(@PathVariable Integer profileId) {
        UpdateProfileNameAndEmail profile = profileService.updateNameSurname(profileId);
        return ResponseEntity.ok(profile);
    }
    @PutMapping("/update/password/detail/result")//✔
    public String updateProfilePasswordDetail(@RequestBody UpdateProfileNameAndEmail profileDTO){
        return  profileService.updateProfilePasswordDetail(profileDTO.getName(), profileDTO.getSurname(),SpringSecurityUtil.getCurrentUserEmail());
    }
    @GetMapping("/update/verification/email/{jtwToken}")
    public ResponseEntity<AuthDTO> emailVerification(@PathVariable("jtwToken") String jwt) {
        AuthDTO edit = profileService.edit(jwt);
        return ResponseEntity.ok(edit);
    }
    @PutMapping("/update/verification/email/success")
    public String emailVerificationEdit(@RequestBody AuthDTO authDTO){
        return  profileService.updateProfilePassword(authDTO.getEmail(), authDTO.getPassword());
    }




}
