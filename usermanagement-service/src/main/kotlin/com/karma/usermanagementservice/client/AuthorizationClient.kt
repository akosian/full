package com.karma.usermanagementservice.client

import com.karma.usermanagementservice.dto.AuthDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.ws.rs.POST

@FeignClient(name = "authorization-service", url = "localhost:9001")
interface AuthorizationClient {

    @PostMapping("/auth")
    fun authorize(@RequestParam("dto") dto: AuthDto): UsernamePasswordAuthenticationToken
}
