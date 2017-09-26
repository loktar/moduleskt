package io.pivotal.moduleskt.app.user.repository

import io.pivotal.moduleskt.user.UserRepository
import org.springframework.stereotype.Component
import io.pivotal.moduleskt.user.UnpersistedUser
import io.pivotal.moduleskt.user.User

@Component
internal class InMemoryUserRepository : UserRepository {
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