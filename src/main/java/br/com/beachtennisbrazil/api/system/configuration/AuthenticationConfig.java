package br.com.beachtennisbrazil.api.system.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class AuthenticationConfig /*extends WebSecurityConfigurerAdapter */{


   /* @Autowired
    private UserDetailsService userDetailsService;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers("/login").permitAll()
    .antMatchers("/admin/**").hasRole("ADMIN")
    .antMatchers("/**").hasAnyRole("ADMIN", "USER")
    .and().formLogin()
    .and().logout().logoutSuccessUrl("/login").permitAll()
    .and().csrf().disable();
  }
}

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    */
}
