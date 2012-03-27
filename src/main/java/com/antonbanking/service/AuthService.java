package com.antonbanking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.antonbanking.business.User;
import com.antonbanking.hibernate.UserDB;

/**
 * A custom authentication manager that allows access if the user details exist in the database and if the username and password are not the same. Otherwise,
 * throw a {@link BadCredentialsException}
 */

/// http://krams915.blogspot.com/2010/12/spring-security-mvc-integration-using_26.html

public class AuthService implements AuthenticationManager
{
    // We need an Md5 encoder since our passwords in the database are Md5 encoded. 
    private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    public Collection<GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));

        return authList;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        // Init a database user object
        UserDB userDB = new UserDB();

        User user;

        try
        {
            // Retrieve user details from database
            user = userDB.findByName(authentication.getName());
        }
        catch (Exception e)
        {
            throw new BadCredentialsException("User does not exists!");
        }

        // Compare passwords
        // Make sure to encode the password first before comparing
        if (passwordEncoder.isPasswordValid(user.getPassword(), (String) authentication.getCredentials(), null) == false)
            throw new BadCredentialsException("Wrong password!");

        // Here's the main logic of this custom authentication manager
        // Username and password must be the same to authenticate
        if (authentication.getName().equals(authentication.getCredentials()) == true)
            throw new BadCredentialsException("Entered username and password are the same!");
        else
            return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), getAuthorities());
    }
}