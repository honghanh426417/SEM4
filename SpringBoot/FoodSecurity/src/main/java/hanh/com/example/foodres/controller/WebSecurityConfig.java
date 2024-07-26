package hanh.com.example.foodres.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests(registry->{
           registry.requestMatchers("/food/list").permitAll();
           registry.requestMatchers("/food/showaddfood").hasRole("ADMIN");
           registry.requestMatchers("/food/showFormForUpdate").hasRole("USER");
           registry.anyRequest().authenticated();
               })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("hanhxinhgai")
                .password("$2a$12$qBPftCNM0lB17.karJl9Iu/CDyMPbnbYrJ1w99XNGrF4R9s/HZyJC")
                .roles("USER")
                .build();
        UserDetails adminUser = User.builder()
                .username("admin")
                .password("$2a$12$YWsmz82/ZYS3QxNGkgSwnOKJ.XAZS4e6we6oz3.sQ0u/QpkI4hiTC")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
