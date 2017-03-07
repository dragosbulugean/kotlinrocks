package com.kotlinrocks

import org.springframework.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(

        var firstName: String,

        var lastName: String,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1

)

interface UserRepo : CrudRepository<User, Long> {
        fun findByLastName(name: String): List<User>
}

