package io.pivotal.moduleskt.user.repository

import io.pivotal.moduleskt.user.domain.UnpersistedUser
import io.pivotal.moduleskt.user.domain.User
import io.pivotal.moduleskt.user.domain.UserRepository
import org.springframework.stereotype.Component

@Component
class InMemoryUserRepository : UserRepository {
    private var idSequence = 1L
    private val users = mutableListOf<User>()

    override fun findAll(): List<User> {
        return users.toList()
    }

    override fun create(unpersistedUser: UnpersistedUser): User {
        val user = User(idSequence++, unpersistedUser.username)
        users.add(user)
        return user
    }
}