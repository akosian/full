package com.karma.usermanagementservice.model

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.SEQUENCE
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity : Serializable {

    @Id
    @GeneratedValue(generator = SEQUENCE_GENERATOR, strategy = SEQUENCE)
    private var id: Long = 0L

    companion object {
        const val SEQUENCE_GENERATOR = "sequence"
        const val ALLOCATION_SIZE = 1
    }
}