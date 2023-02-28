package com.example.config;

import com.example.entity.Profile;
import com.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // username -> alish
        Profile optional = profileRepository.findByEmail(email);
        if (optional == null) {
            throw new UsernameNotFoundException("Bad Cretetional");
        }

        return new CustomUserDetails(optional);
    }
}
