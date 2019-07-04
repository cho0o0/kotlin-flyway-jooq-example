package com.hitoda.kotlinflywayjooq

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.hitoda.kotlinflywayjooq.view.models.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp
import java.time.LocalDateTime
import org.hamcrest.Matchers.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@SpringBootTest
@RunWith(SpringRunner::class)
@Transactional
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserControllerTest {
    @Autowired
    lateinit var mvc: MockMvc

    private val email = "${Timestamp.valueOf(LocalDateTime.now()).nanos}@example.com"

    @Test
    fun a1ShouldReturnList() {
        mvc.perform(get("/")).andDo(print()).andExpect(status().isOk)
                .andExpect(content().string(`is`("[]")))
    }

    @Test
    fun a2ShouldAddUser() {
        mvc.perform(post("/$email"))
                .andDo(print())
                .andExpect(status().isCreated)
                .andExpect(jsonPath("$.email", `is`(email)))
        val contentAsString = mvc.perform(get("/")).andDo(print()).andExpect(status().isOk)
                .andReturn()
                .response.contentAsString
        val users = jacksonObjectMapper().readValue<List<User>>(contentAsString)
        assertThat(users).hasSize(1)
    }

    @Test
    fun a3ShouldDeleteUser() {
        mvc.perform(delete("/$email"))
                .andDo(print())
                .andExpect(status().isOk)
        mvc.perform(get("/")).andDo(print()).andExpect(status().isOk)
                .andExpect(content().string(`is`("[]")))

    }
}