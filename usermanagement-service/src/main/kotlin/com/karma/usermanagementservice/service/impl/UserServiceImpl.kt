package com.karma.usermanagementservice.service.impl

import com.karma.usermanagementservice.repository.UserRepository
import com.karma.usermanagementservice.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val repository: UserRepository,
) : UserService {

    override fun findByUsername(username: String) =
        repository.findByUsername(username).orElseThrow { Exception("No such user") }
}
