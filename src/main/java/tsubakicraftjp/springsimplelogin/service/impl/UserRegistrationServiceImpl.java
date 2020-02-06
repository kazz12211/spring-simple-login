package tsubakicraftjp.springsimplelogin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tsubakicraftjp.springsimplelogin.exception.InvalidPasswordException;
import tsubakicraftjp.springsimplelogin.exception.UserAlreadyExistsException;
import tsubakicraftjp.springsimplelogin.form.RegistrationFormData;
import tsubakicraftjp.springsimplelogin.model.AuthUser;
import tsubakicraftjp.springsimplelogin.repository.UserRepository;
import tsubakicraftjp.springsimplelogin.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
        
    @Override
    public void register(RegistrationFormData data) throws Exception {
        AuthUser user = userRepository.findByUsername(data.getUsername());
        if(user != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        if(data.getPassword().length() < 4) {
            throw new InvalidPasswordException("Invalid password");
        }
        user = new AuthUser();
        user.setUsername(data.getUsername());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setAuthorityList("ROLE_USER");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        userRepository.save(user);
    }
    
}