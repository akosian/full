package com.karma.authorizationservice.service

import com.karma.authorizationservice.security.JwtTokenProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    private val tokenProvider: JwtTokenProvider,
) {

    fun getAuthorization(token: String): Boolean {
        val resolverToken = tokenProvider.resolveToken(token)
        if (resolverToken != null && tokenProvider.validateToken(resolverToken)) {
            return true
        } else {
            throw Exception("Not valid token")
        }
    }
}
