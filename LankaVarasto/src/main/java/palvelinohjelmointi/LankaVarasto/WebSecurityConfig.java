package palvelinohjelmointi.LankaVarasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import palvelinohjelmointi.LankaVarasto.web.UserDetailServiceImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailServiceImpl userDetailsService;
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests()
	        .antMatchers("/css/**").permitAll()
	        .antMatchers("/").anonymous()
	        .and()
	        .authorizeRequests()
	        .antMatchers("/h2-console/**").permitAll()
	        .and()
	        .authorizeRequests()
	        .anyRequest().authenticated()
	        .and()
	        .csrf().disable()
	        .headers().frameOptions().disable()
	        .and()
	      .formLogin()
	          .defaultSuccessUrl("/lankalista",true)
	          .permitAll()
	          .and()
	      .logout()
	          .permitAll();
	      
	        
	    }
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }
}
