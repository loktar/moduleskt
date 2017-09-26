package io.pivotal.moduleskt.user.api

import io.pivotal.moduleskt.user.domain.CreateUserUseCase
import io.pivotal.moduleskt.user.domain.FindAllUsersUseCase
import io.pivotal.moduleskt.user.domain.UnpersistedUser
import io.pivotal.moduleskt.user.domain.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UsersController(
        private val findAllUsersUseCase: FindAllUsersUseCase,
        private val createUserUseCase: CreateUserUseCase
) {
    @GetMapping
    fun index(): UserListResponse {
        val users = findAllUsersUseCase.execute()
        return userListResponse(users)
    }

    @PostMapping
    fun create(@RequestParam username: String): UserResponse {
        val unpersistedUser = UnpersistedUser(username)
        val user = createUserUseCase.execute(unpersistedUser)
        return userResponse(user)
    }

    private fun userResponse(user: User): UserResponse =
            UserResponse(user.id, user.username)

    private fun userListResponse(users: List<User>) =
            UserListResponse(users.map { userResponse(it) })
}
