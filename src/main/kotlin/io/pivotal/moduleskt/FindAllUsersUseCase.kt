package io.pivotal.moduleskt

import org.springframework.stereotype.Component

@Component
class FindAllUsersUseCase(
        private val inMemoryUserRepository: InMemoryUserRepository
) {
    fun execute(): List<User> {
        return inMemoryUserRepository.findAll()
    }
}
