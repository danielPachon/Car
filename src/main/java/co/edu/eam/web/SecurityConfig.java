package co.edu.eam.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin1234")
                .roles("ADMIN", "USER")
                .and()
                .withUser("usuario")
                .password("usuario1234")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registrar/**","/editar/**", "/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errors/403");
    }
}