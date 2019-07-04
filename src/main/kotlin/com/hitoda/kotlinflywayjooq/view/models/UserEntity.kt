package com.hitoda.kotlinflywayjooq.view.models

data class UserEntity(val id: Long, val email: String, val deleted: Boolean) {
   fun toDto() = User(id, email)
}