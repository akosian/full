package com.karma.usermanagementservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "authorization-service", url = "localhost:9001")
interface AuthorizationClient {

    @PostMapping("/auth")
    fun authorize(token: String): UsernamePasswordAuthenticationToken
}
