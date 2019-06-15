package pl.itkontekst.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSercurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/customers/**").hasRole("ADMIN")
                .antMatchers("/public/**").permitAll()
            .and()
            .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws  Exception{
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN","USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
