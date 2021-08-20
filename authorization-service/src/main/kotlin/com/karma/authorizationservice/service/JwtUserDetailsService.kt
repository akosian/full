package com.karma.authorizationservice.service

import com.karma.authorizationservice.client.UserClient
import com.karma.authorizationservice.model.JwtUser
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService(private val userClient: UserClient) : UserDetailsService {

    override fun loadUserByUsername(username: String) =
//            userClient.getUserByUsername(username).let { JwtUser(it.username, it.password) }
        Pair("admin",BCryptPasswordEncoder().encode("admin")).let { JwtUser(it.first, it.second) }
}
