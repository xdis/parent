package com.zyxy.auth;

import com.zyxy.auth.config.ApiErrorWebResponseExceptionTranslator;
import com.zyxy.auth.security.authentication.MyDaoAuthenticationProvider;
import com.zyxy.auth.security.service.DBUserDetailsServiceImpl;
import com.zyxy.auth.security.token.MyRedisTokenStore;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableResourceServer
@ComponentScan({"com.zyxy"})
@MapperScan({"com.zyxy.common.mapper"})
@EnableTransactionManagement
@EnableCaching
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AuthApplication.class);
    }

    @Configuration
    @EnableWebSecurity
    protected static class webSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private DBUserDetailsServiceImpl userDetailsService;

        @Autowired
        private StringRedisTemplate stringRedisTemplate;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
			http
				.authorizeRequests().anyRequest().authenticated()
            .and()
				.csrf().disable();
			// @formatter:on
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            MyDaoAuthenticationProvider myDaoAuthenticationProvider = new MyDaoAuthenticationProvider();
            myDaoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
            myDaoAuthenticationProvider.setUserDetailsService(userDetailsService);
            myDaoAuthenticationProvider.setStringRedisTemplate(stringRedisTemplate);
            return new ProviderManager(Arrays.asList((AuthenticationProvider) myDaoAuthenticationProvider));
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
        @Value("${security.accessToken.validity.seconds}")
        private int accessTokenValiditySeconds;

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Autowired
        private DBUserDetailsServiceImpl userDetailsService;

        @Autowired
        private Environment env;

        @Autowired
        private RedisConnectionFactory connectionFactory;

        @Autowired
        private DBUserDetailsServiceImpl dbUserDetailsService;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            // @formatter:off
			clients.inMemory()
					.withClient("browser")
					.authorizedGrantTypes("refresh_token", "password")
					.scopes("ui")
                    .accessTokenValiditySeconds(accessTokenValiditySeconds)
			.and()
					.withClient("adminService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("apiService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("coreService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("fileService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("messageService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("thirdService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("apiCoreService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("schedulerService")
					.secret("ROOT")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server");
//			.and()
//					.withClient("notification-service")
//					.secret(env.getProperty("NOTIFICATION_SERVICE_PASSWORD"))
//					.authorizedGrantTypes("client_credentials", "refresh_token")
//					.scopes("server");
			// @formatter:on
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(tokenStore())
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userDetailsService)
                    .reuseRefreshTokens(false)
                    .exceptionTranslator(new ApiErrorWebResponseExceptionTranslator());
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer
                    .tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()");
        }

        @Bean
        public TokenStore tokenStore() {
            return new MyRedisTokenStore(connectionFactory, dbUserDetailsService, accessTokenValiditySeconds);
        }
    }
}
