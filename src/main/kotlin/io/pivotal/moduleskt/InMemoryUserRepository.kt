package io.pivotal.moduleskt

import org.springframework.stereotype.Component

@Component
class InMemoryUserRepository {
    private var idSequence = 1L
    private val users = mutableListOf<User>()

    fun findAll(): List<User> {
        return users.toList()
    }

    fun create(unpersistedUser: UnpersistedUser): User {
        val user = User(idSequence++, unpersistedUser.username)
        users.add(user)
        return user
    }
}