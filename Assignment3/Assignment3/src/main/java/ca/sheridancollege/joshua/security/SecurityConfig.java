package ca.sheridancollege.joshua.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity

	public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailedServiceImpl userDetailedServiceImpl;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}

	@Autowired
	AccessDeniedHandler accessdeniedhandler;
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();//remove in deployment
		http.headers().frameOptions().disable();//remove in deployment
		http
		.authorizeRequests()
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers(
				"/",
				"/js/**",
				"/css/**",
				"/images/**",
		         "/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll()
		.and()
		   .exceptionHandling()
		   .accessDeniedHandler(accessdeniedhandler);;
		
	}
	
	@Autowired //HW -> Why are we annotating a method?          
  public void	configureGlobal (AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userDetailedServiceImpl)
		.passwordEncoder(passwordEncoder());

  }

}
