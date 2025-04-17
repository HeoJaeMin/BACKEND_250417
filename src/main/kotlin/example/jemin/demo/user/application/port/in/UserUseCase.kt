package example.jemin.demo.user.application.port.`in`

import example.jemin.demo.user.domain.User

interface UserUseCase {
    fun getUser(id: Long): User
}
