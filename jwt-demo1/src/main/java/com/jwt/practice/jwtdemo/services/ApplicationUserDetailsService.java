//package com.jwt.practice.jwtdemo.services;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.jwt.practice.jwtdemo.models.ApplicationUser;
//import com.jwt.practice.jwtdemo.repositories.ApplicationUserRepository;
//
//@Service
//public class ApplicationUserDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private ApplicationUserRepository applicationUserRepository;
////
////    public ApplicationUserDetailsService(ApplicationUserRepository applicationUserRepository) {
////        this.applicationUserRepository = applicationUserRepository;
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
////        if (applicationUser == null) {
////            throw new UsernameNotFoundException(username);
////        }
//        return new User("user", "Test12345_", new ArrayList());
//    }
//}
