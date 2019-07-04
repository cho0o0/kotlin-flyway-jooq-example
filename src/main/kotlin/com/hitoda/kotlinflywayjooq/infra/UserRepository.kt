package com.hitoda.kotlinflywayjooq.infra

import com.hitoda.kotlinflywayjooq.infra.generated.tables.Users
import com.hitoda.kotlinflywayjooq.view.models.UserEntity
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    @Autowired
    lateinit var dsl: DSLContext

    fun insert(email: String): UserEntity {
        return dsl.insertInto(Users.USERS, Users.USERS.EMAIL, Users.USERS.DELETED)
                .values(email, false)
                .returning(Users.USERS.ID, Users.USERS.EMAIL, Users.USERS.DELETED)
                .fetchOne()
                .into(UserEntity::class.java)
    }

    fun list(): List<UserEntity> {
        return dsl.select(Users.USERS.ID, Users.USERS.EMAIL, Users.USERS.DELETED)
                .from(Users.USERS)
                .fetchInto(UserEntity::class.java)
    }

    fun delete(email: String) {
        dsl.update(Users.USERS).set(Users.USERS.DELETED, true).where(Users.USERS.EMAIL.eq(email)).execute()
    }
}