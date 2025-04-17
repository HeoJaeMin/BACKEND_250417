package example.jemin.demo.user.application.service

import example.jemin.demo.user.application.port.`in`.UserUseCase
import example.jemin.demo.user.application.port.out.UserPort
import example.jemin.demo.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userPort: UserPort) : UserUseCase {
    override fun getUser(id: Long): User = userPort.findUser(id) ?: throw RuntimeException("User not found")
}
