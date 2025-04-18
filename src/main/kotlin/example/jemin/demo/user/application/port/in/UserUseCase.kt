package example.jemin.demo.user.application.port.`in`

import example.jemin.demo.user.application.port.`in`.command.EmailDuplicateCheckCommand
import example.jemin.demo.user.application.port.`in`.command.UserSaveCommand
import example.jemin.demo.user.application.port.`in`.command.UserSearchCommand
import example.jemin.demo.user.domain.User

interface UserUseCase {
    fun getUser(userSearchCommand: UserSearchCommand): User
    fun checkEmailDuplicate(emailDuplicateCheckCommand: EmailDuplicateCheckCommand): Boolean
    fun saveUser(userSaveCommand: UserSaveCommand): User
}
