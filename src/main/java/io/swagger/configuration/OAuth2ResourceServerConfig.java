/**
 * 
 */
package io.swagger.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
@SuppressWarnings("deprecation")
@Configuration
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter  {

	  @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .antMatchers("/api/**").authenticated()
	            .antMatchers("/").permitAll();
	    }
}
