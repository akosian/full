package com.karma.authorizationservice.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(private val userDetailsService: UserDetailsService) {

    private var secret: String = "secret"

    @PostConstruct
    fun init() {
        secret = Base64.getEncoder().encodeToString(secret.toByteArray())
    }

    fun createToken(username: String) =
            Jwts.builder().let {
                it.setClaims(Jwts.claims().setSubject(username))
//                it.setIssuedAt(Date(Date().time + 3000L))
                it.setExpiration(Date(Date().time + 100000000))
                it.signWith(SignatureAlgorithm.HS512, secret)
                it.compact()
            }


    fun getAuthentication(token: String) =
            this.userDetailsService.loadUserByUsername(getUsername(token)).let {
                UsernamePasswordAuthenticationToken(it, "", it.authorities)
            }

    fun getUsername(token: String) = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body.subject

    fun resolveToken(token: String) =
        token.let {
                if (it.startsWith(TOKEN_PREFIX)) it.substring(TOKEN_PREFIX.length, it.length)
                else null
            }

    fun validateToken(token: String) =
            true

    companion object {
        const val TOKEN_PREFIX = "Bearer_"
    }
}
