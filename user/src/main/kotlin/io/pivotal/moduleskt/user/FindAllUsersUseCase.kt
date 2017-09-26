package io.pivotal.moduleskt.user

import org.springframework.stereotype.Component

@Component
class FindAllUsersUseCase(
        private val userRepository: UserRepository
) {
    fun execute(): List<User> {
        return userRepository.findAll()
    }
}
