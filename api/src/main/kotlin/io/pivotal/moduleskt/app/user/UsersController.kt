package io.pivotal.moduleskt.app.user

import io.pivotal.moduleskt.user.CreateUserUseCase
import io.pivotal.moduleskt.user.FindAllUsersUseCase
import io.pivotal.moduleskt.user.UnpersistedUser
import io.pivotal.moduleskt.user.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
internal class UsersController(
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
