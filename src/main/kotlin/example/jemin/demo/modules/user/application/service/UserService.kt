package example.jemin.demo.modules.user.application.service

import example.jemin.demo.common.config.exception.error.extend.UserDuplicateError
import example.jemin.demo.common.config.exception.error.extend.UserNotFoundError
import example.jemin.demo.common.response.ErrorDetail
import example.jemin.demo.modules.user.application.port.`in`.UserUseCase
import example.jemin.demo.modules.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.modules.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.modules.user.application.port.`in`.command.SingleUserSearchCommand
import example.jemin.demo.modules.user.application.port.`in`.command.UserSaveCommand
import example.jemin.demo.modules.user.application.port.out.UserPort
import example.jemin.demo.modules.user.domain.User
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

    override fun saveUser(userSaveCommand: UserSaveCommand): User {
        if (userPort.checkDuplicate(
                DuplicateCheckCommand(
                    email = userSaveCommand.email,
                    nickName = null,
                ),
            )
        ) {
            throw UserDuplicateError(
                errorDetail = listOf(
                    ErrorDetail(
                        reason = "Email already in use",
                        message = userSaveCommand.email,
                    ),
                ),
            )
        }

        if (userPort.checkDuplicate(
                DuplicateCheckCommand(
                    email = null,
                    nickName = userSaveCommand.nickName,
                ),
            )
        ) {
            throw UserDuplicateError(
                errorDetail = listOf(
                    ErrorDetail(
                        reason = "NickName already in use",
                        message = userSaveCommand.nickName,
                    ),
                ),
            )
        }
        return userPort.save(userSaveCommand.toDomain())
    }

    override fun getAllUsers(multipleUserSearchCommand: MultipleUserSearchCommand): List<User> =
        userPort.findAll(multipleUserSearchCommand)
}
