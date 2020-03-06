package dev.mateuszkowalczyk.puncher.service;

import dev.mateuszkowalczyk.puncher.entity.User;
import dev.mateuszkowalczyk.puncher.model.MyUserDetails;
import dev.mateuszkowalczyk.puncher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public MyUserDetailsService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);

        if(user.isPresent()) {
            return new MyUserDetails(user.get());
        }

        throw new UsernameNotFoundException("Cannot find with username:" + username);
    }

}
