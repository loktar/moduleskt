package io.pivotal.moduleskt.user.domain

interface UserRepository {
    fun findAll(): List<User>
    fun create(unpersistedUser: UnpersistedUser): User
}