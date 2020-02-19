package com.orders.management.Configuration;

import com.orders.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   // @Qualifier("UserDetailService")
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
        

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

/*
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}pass") // Spring Security 5 requires specifying the password storage format
                .roles("USER")
                .and()
                .withUser("root")
                .password("{noop}root")
                .roles("ADMIN");*/


    /*    auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select login, password, active from users where login=?")
                .authoritiesByUsernameQuery("select u.login, r.role_name from users u, role_table r, role_ids uhr WHERE u.user_id = uhr.users_ids AND r.id = uhr.role_ids where u.login=?");
*/
    auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getpasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
