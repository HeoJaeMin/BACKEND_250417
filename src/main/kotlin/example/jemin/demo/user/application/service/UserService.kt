package example.jemin.demo.user.application.service

import example.jemin.demo.common.ErrorDetail
import example.jemin.demo.config.exception.error.extend.UserNotFoundError
import example.jemin.demo.user.application.port.`in`.UserUseCase
import example.jemin.demo.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.user.application.port.`in`.command.SingleUserSearchCommand
import example.jemin.demo.user.application.port.`in`.command.UserSaveCommand
import example.jemin.demo.user.application.port.out.UserPort
import example.jemin.demo.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userPort: UserPort) : UserUseCase {
    override fun getUser(singleUserSearchCommand: SingleUserSearchCommand): User =
        userPort.findById(singleUserSearchCommand.id) ?: throw UserNotFoundError(
            errorDetail = listOf(
                ErrorDetail(
                    "CANNOT FOUND WITH ID",
                    singleUserSearchCommand.id.toString(),
                ),
            ),
        )

    override fun checkEmailDuplicate(duplicateCheckCommand: DuplicateCheckCommand): Boolean =
        userPort.checkDuplicate(duplicateCheckCommand)

    override fun saveUser(userSaveCommand: UserSaveCommand): User = userPort.save(userSaveCommand.toDomain())
    override fun getAllUsers(multipleUserSearchCommand: MultipleUserSearchCommand): List<User> =
        userPort.findAll(multipleUserSearchCommand)
}
