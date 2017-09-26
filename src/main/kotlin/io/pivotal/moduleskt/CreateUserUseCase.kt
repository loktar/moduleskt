package io.pivotal.moduleskt

import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
        private val inMemoryUserRepository: InMemoryUserRepository
) {
    fun execute(unpersistedUser: UnpersistedUser): User {
        return inMemoryUserRepository.create(unpersistedUser)
    }
}