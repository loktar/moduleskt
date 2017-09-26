package io.pivotal.moduleskt.user

import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
        private val userRepository: UserRepository
) {
    fun execute(unpersistedUser: UnpersistedUser): User {
        return userRepository.create(unpersistedUser)
    }
}