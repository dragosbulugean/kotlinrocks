package com.kotlinrocks

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApi(val userRepo : UserRepo) {

    @GetMapping("/users")
    fun getUsers() = userRepo.findAll()

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User {
        user.id = -1
        return userRepo.save(user)
    }

}


