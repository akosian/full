package com.karma.authorizationservice.controller

import com.karma.authorizationservice.dto.AuthDto
import com.karma.authorizationservice.dto.UserDto
import com.karma.authorizationservice.security.JwtTokenProvider
import com.karma.authorizationservice.service.AuthorizationService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/auth")
class AuthorizationController(
    private val authenticationManager: AuthenticationManager,
    private val service: AuthorizationService,
    private val jwtTokenProvider: JwtTokenProvider
) {

    @PostMapping
    fun authorize(dto: AuthDto) =
        service.getAuthorization(dto.token)

    @PostMapping("/login")
    fun login(userDto: UserDto): String {
        val username = userDto.username
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, userDto.password))
            ?: throw BadCredentialsException("Invalid username or password")

        return jwtTokenProvider.createToken(userDto.username)
    }
}
