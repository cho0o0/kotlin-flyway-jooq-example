package com.hitoda.kotlinflywayjooq.view

import com.hitoda.kotlinflywayjooq.domain.UserService
import com.hitoda.kotlinflywayjooq.view.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Email

@RestController
class UserController {
    @Autowired
    lateinit var service: UserService

    @GetMapping("/")
    fun get(): List<User> {
        return service.listUsers().map { it.toDto() }
    }

    @PostMapping("/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Email @PathVariable email: String): User {
        return service.createUser(email).toDto()
    }

    @DeleteMapping("/{email}")
    fun delete(@Email @PathVariable email: String) {
        return service.removeUser(email)
    }
}