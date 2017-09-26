package io.pivotal.moduleskt.user

interface UserRepository {
    fun findAll(): List<User>
    fun create(unpersistedUser: UnpersistedUser): User
}