package com.karma.usermanagementservice.security

import com.karma.usermanagementservice.client.AuthorizationClient
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JwtConfigurer(private val authorizationClient: AuthorizationClient) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(security: HttpSecurity) {
        val filter = JwtTokenFilter(authorizationClient)
        security.addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
    }
}
