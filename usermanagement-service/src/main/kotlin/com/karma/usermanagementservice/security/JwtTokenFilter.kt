package com.karma.usermanagementservice.security

import com.karma.usermanagementservice.client.AuthorizationClient
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtTokenFilter(private val authorizationClient: AuthorizationClient) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val token = (request as HttpServletRequest).getHeader("Authorization")
        if(token != null) {
            SecurityContextHolder.getContext().authentication = authorizationClient.authorize(token)
        }else {
            throw Exception("Token doesn't provided")
        }
        chain.doFilter(request, response)
    }
}
