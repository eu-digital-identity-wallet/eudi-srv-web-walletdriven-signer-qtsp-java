package eu.europa.ec.eudi.signer.r3.authorization_server.web.config;

import eu.europa.ec.eudi.signer.r3.authorization_server.model.oid4vp.OpenIdForVPService;
import eu.europa.ec.eudi.signer.r3.authorization_server.model.oid4vp.VerifierClient;
import eu.europa.ec.eudi.signer.r3.authorization_server.model.oid4vp.variables.SessionUrlRelationList;
import eu.europa.ec.eudi.signer.r3.authorization_server.model.user.UserRepository;
import eu.europa.ec.eudi.signer.r3.authorization_server.web.security.oid4vp.*;
import eu.europa.ec.eudi.signer.r3.authorization_server.web.security.oid4vp.handler.OID4VPAuthenticationFailureHandler;
import eu.europa.ec.eudi.signer.r3.authorization_server.web.security.oid4vp.handler.OID4VPAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.ChangeSessionIdAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize ->
				authorize
					.requestMatchers("/oid4vp/callback").permitAll()
					.requestMatchers("/error").permitAll()
					.anyRequest().authenticated()
			)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
		return http.build();
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Bean
	public CustomUserDetailsService userDetailsService(UserRepository userRepository){
		return new CustomUserDetailsService(userRepository);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationManagerProvider authenticationManagerProvider) throws Exception {
		return new ProviderManager(authenticationManagerProvider);
	}

	@Bean
	public OID4VPAuthenticationSuccessHandler customAuthenticationSuccessHandler(SessionUrlRelationList sessionUrlRelationList){
		return new OID4VPAuthenticationSuccessHandler(sessionUrlRelationList);
	}

	@Bean
	public OID4VPAuthenticationFailureHandler customAuthenticationFailureHandler(){
		return new OID4VPAuthenticationFailureHandler();
	}

	@Bean
	public OID4VPAuthenticationFilter authenticationFilter(
		AuthenticationManager authenticationManager, OID4VPAuthenticationSuccessHandler authenticationSuccessHandler,
		OID4VPAuthenticationFailureHandler authenticationFailureHandler, VerifierClient verifierClient,
		OpenIdForVPService oid4vpService, SessionUrlRelationList sessionUrlRelationList){

		OID4VPAuthenticationFilter filter = new OID4VPAuthenticationFilter(authenticationManager, verifierClient, oid4vpService, sessionUrlRelationList);
		filter.setSessionAuthenticationStrategy(new ChangeSessionIdAuthenticationStrategy());
		filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		filter.setAuthenticationFailureHandler(authenticationFailureHandler);
		return filter;
	}
}
