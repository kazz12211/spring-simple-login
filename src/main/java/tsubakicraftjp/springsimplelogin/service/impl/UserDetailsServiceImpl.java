package tsubakicraftjp.springsimplelogin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import tsubakicraftjp.springsimplelogin.model.AuthUser;
import tsubakicraftjp.springsimplelogin.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AuthUser aUser = userRepository.findByUsername(username);
        if(aUser == null) {
            return null;
        }
        User user = new User(
            aUser.getUsername(),
            aUser.getPassword(),
            aUser.isEnabled(),
            aUser.isAccountNonExpired(),
            aUser.isCredentialsNonExpired(),
            aUser.isAccountNonLocked(), 
            AuthorityUtils.commaSeparatedStringToAuthorityList(aUser.getAuthorityList()));
        return user;
    }
}