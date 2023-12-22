package com.surpass.controllers;

import com.surpass.entities.AuthModel;
import com.surpass.entities.JwtResponse;
import com.surpass.entities.User;
import com.surpass.entities.UserModel;
import com.surpass.security.CustomUserDetailsService;
import com.surpass.services.UserService;
import com.surpass.util.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthModel authModel) throws Exception {

//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(
//                authModel.getEmail(),
//                authModel.getPassword()
//        ));

        authenticate(authModel.getEmail(), authModel.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authModel.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);

    }

    private void authenticate(String email, String password) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    email,
                    password
            ));

        } catch (DisabledException e) {

            throw new Exception("User disabled.");

        } catch (BadCredentialsException e) {

            throw new Exception("Bad Credentials");

        }

    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {

        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);

    }

}
