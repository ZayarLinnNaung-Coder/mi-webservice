package org.ace.insurance.adminserver.security.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AdminServerProperties adminServer;
    private final SecurityProperties security;

    public SecurityConfig(AdminServerProperties adminServer, SecurityProperties security) {
        this.adminServer = adminServer;
        this.security = security;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(this.adminServer.path("/"));

        http.authorizeHttpRequests(auth ->
                auth.requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/assets/**"))).permitAll()
                        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/**/*.css"))).permitAll()
                        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/actuator/info"))).permitAll()
                        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/actuator/health"))).permitAll()
                        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/login"))).permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin.loginPage(this.adminServer.path("/login")).successHandler(successHandler).and())
                .logout(logout -> logout.logoutUrl(this.adminServer.path("/logout")))
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .ignoringRequestMatchers(
                                new AntPathRequestMatcher(this.adminServer.path("/instances"),
                                        HttpMethod.POST.toString()),
                                new AntPathRequestMatcher(this.adminServer.path("/instances/*"),
                                        HttpMethod.DELETE.toString()),
                                new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))
                        ))
                .csrf().disable();
        return http.build();
    }

}