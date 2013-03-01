/**
 * 
 */
package com.digitalchalk.social.googleplus.webtest.config;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.embedded.*;
import org.springframework.jdbc.datasource.init.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.crypto.encrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.social.connect.*;
import org.springframework.social.connect.jdbc.*;
import org.springframework.social.connect.support.*;
import org.springframework.social.connect.web.*;

import com.digitalchalk.social.googleplus.*;
import com.digitalchalk.social.googleplus.webtest.common.*;

/**
 * @author brobinson
 *
 */
@Configuration
@PropertySource(value = "classpath:gplus.connect.properties", name="gplus")
@ComponentScan(basePackageClasses=AccountRepository.class)
public class SecurityServletConfig {
	
	@Autowired
    Environment env;

	
	@Bean
	@Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES) 
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new GooglePlusConnectionFactory("gplus", new GooglePlusServiceProvider(env.getProperty("gplus.client_id"), env.getProperty("gplus.client_secret"), env.getProperty("gplus.authorize_url"), env.getProperty("gplus.token_url")), new GooglePlusApiAdapter() ));
		return registry;
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public ConnectionRepository connectionRepository() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		return usersConnectionRepository().createConnectionRepository(authentication.getName());
	}
	
	@Bean
	public ConnectController connectController() {
		ConnectController connectController = new ConnectController(connectionFactoryLocator(), connectionRepository());
//		connectController.addInterceptor(new GooglePlusConnectInterceptor());
//		connectController.addDisconnectInterceptor(new GooglePlusDisconnectInterceptor());
		return connectController;
	}
	
	// SECURITY DATABASE BEANS
	// Local fake database for holding "user accounts" 
	
	@Bean(destroyMethod = "shutdown")
	public DataSource connectDataSource() {
		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
		factory.setDatabaseName("sendgridapp");
		factory.setDatabaseType(EmbeddedDatabaseType.H2);
		factory.setDatabasePopulator(databasePopulator());
		return factory.getDatabase();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(connectDataSource());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
    	return NoOpPasswordEncoder.getInstance();
	}
    
	@Bean
	public TextEncryptor textEncryptor() {
		return Encryptors.noOpText();
	}
	
	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("JdbcUsersConnectionRepository.sql", JdbcUsersConnectionRepository.class));
		populator.addScript(new ClassPathResource("/sql/Account.sql", JdbcAccountRepository.class));
		populator.addScript(new ClassPathResource("/sql/data.sql", JdbcAccountRepository.class));
		return populator;
	}
	
	@Bean
	@Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES) 
	public UsersConnectionRepository usersConnectionRepository() {
		return new JdbcUsersConnectionRepository(connectDataSource(), connectionFactoryLocator(), Encryptors.noOpText());
	}
	
	
}
