package com.karma.usermanagementservice.service

import com.karma.usermanagementservice.model.User

interface UserService {

    fun findByUsername(username: String): User
}
