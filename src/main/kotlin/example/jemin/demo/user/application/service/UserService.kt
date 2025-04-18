package example.jemin.demo.user.application.service

import example.jemin.demo.common.ErrorDetail
import example.jemin.demo.config.exception.error.extend.UserNotFoundError
import example.jemin.demo.user.application.port.`in`.UserUseCase
import example.jemin.demo.user.application.port.`in`.command.EmailDuplicateCheckCommand
import example.jemin.demo.user.application.port.`in`.command.UserSaveCommand
import example.jemin.demo.user.application.port.`in`.command.UserSearchCommand
import example.jemin.demo.user.application.port.out.UserPort
import example.jemin.demo.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userPort: UserPort) : UserUseCase {
    override fun getUser(userSearchCommand: UserSearchCommand): User =
        userPort.findById(userSearchCommand.id) ?: throw UserNotFoundError(
            errorDetail = listOf(
                ErrorDetail(
                    "CANNOT FOUND WITH ID",
                    userSearchCommand.id.toString(),
                ),
            ),
        )

    override fun checkEmailDuplicate(emailDuplicateCheckCommand: EmailDuplicateCheckCommand): Boolean =
        userPort.checkEmailDuplicate(emailDuplicateCheckCommand.email)

    override fun saveUser(userSaveCommand: UserSaveCommand): User = userPort.save(userSaveCommand.toDomain())
}
