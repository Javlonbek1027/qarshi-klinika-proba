package com.example.util;

import com.example.config.CustomUserDetails;
import com.example.entity.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityUtil {

    public static Profile getCurrentEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        /* System.out.println(user.getUsername());
        Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) user.getAuthorities();
         Collection<? extends GrantedAuthority> authorities = user.getAuthorities();*/
        return user.getProfile();
    }

    public static Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return Math.toIntExact(user.getProfile().getId());
    }
    public static String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user.getProfile().getEmail();
    }
}
