package com.karma.usermanagementservice.model

import com.karma.usermanagementservice.model.BaseEntity.Companion.ALLOCATION_SIZE
import com.karma.usermanagementservice.model.BaseEntity.Companion.SEQUENCE_GENERATOR
import javax.persistence.Entity
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "USERS")
@SequenceGenerator(
        name = SEQUENCE_GENERATOR, sequenceName = "SEQ_USER", allocationSize = ALLOCATION_SIZE
)
class User(
        var username: String,
        var password: String,
        var email: String
) : BaseEntity()
