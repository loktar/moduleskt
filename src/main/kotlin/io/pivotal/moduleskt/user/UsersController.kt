package io.pivotal.moduleskt.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UsersController(
        private val findAllUsersUseCase: FindAllUsersUseCase,
        private val createUserUseCase: CreateUserUseCase
) {
    @GetMapping
    fun index(): List<User> {
        return findAllUsersUseCase.execute()
    }

    @PostMapping
    fun create(@RequestParam username: String): User {
        val unpersistedUser = UnpersistedUser(username)
        return createUserUseCase.execute(unpersistedUser)
    }
}
