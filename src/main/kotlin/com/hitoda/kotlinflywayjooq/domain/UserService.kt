package com.hitoda.kotlinflywayjooq.domain

import com.hitoda.kotlinflywayjooq.infra.UserRepository
import com.hitoda.kotlinflywayjooq.view.models.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var repo: UserRepository

    fun createUser(email: String): UserEntity {
        return repo.insert(email)
    }

    fun listUsers(): List<UserEntity> {
        return repo.list()
    }

    fun removeUser(email: String) {
        return repo.delete(email)
    }
}