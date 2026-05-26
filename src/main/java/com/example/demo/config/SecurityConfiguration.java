package com.example.demo.config;

import com.example.demo.model.Authority;
import com.example.demo.model.Member;
import com.example.demo.model.MemberUser;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/article/list", "/article/content").permitAll()
                        .requestMatchers("/member/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/signup").permitAll()
                        .requestMatchers("/health").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .formLogin(form -> form
                        .loginPage("/login").permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserDetailsService userDetailsServiceEmbeded(MemberRepository memberRepository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Member member = memberRepository.findByEmail(username).orElseThrow();
                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        return List.of();
                    }

                    @Override
                    public String getPassword() {
                        return member.getPassword();
                    }

                    @Override
                    public String getUsername() {
                        return member.getEmail();
                    }
                };
            }
        };
    }

    @Bean
    public UserDetailsService userDetailsService(MemberRepository memberRepository, AuthorityRepository authorityRepository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Member member = memberRepository.findByEmail(username).orElseThrow();
                List<Authority> authorities = authorityRepository.findByMember(member);
                return new MemberUser(member, authorities);
            }
        };
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web.ignoring().requestMatchers(
                        "/css/**",
                        "/js/**",
                        "/image/**",
                        "/health/**",
                        "/actuator/**",
                        "/h2-console/**");
            }
        };
    }

    public FilterRegistrationBean<OpenEntityManagerInViewFilter> filterRegistrationBeanForOpenEntityManagerInViewFilter() {
        FilterRegistrationBean<OpenEntityManagerInViewFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new OpenEntityManagerInViewFilter());
        filterFilterRegistrationBean.setOrder(Integer.MIN_VALUE);
        return filterFilterRegistrationBean;
    }

}