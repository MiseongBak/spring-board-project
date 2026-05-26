package com.example.demo.model;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
public class MemberUser implements UserDetails {
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
    // Extras
    private String name;
    private Long id;

    public MemberUser(Member member, List<Authority> authorities){
        this.username = member.getEmail();
        this.name = member.getName();
        this.password = member.getPassword();
        this.id = member.getId();
        this.authorities = authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).toList();
    }
}
