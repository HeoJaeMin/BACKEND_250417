package example.jemin.demo.user.application.port.`in`

import example.jemin.demo.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.user.application.port.`in`.command.SingleUserSearchCommand
import example.jemin.demo.user.application.port.`in`.command.UserSaveCommand
import example.jemin.demo.user.domain.User

interface UserUseCase {
    fun getUser(singleUserSearchCommand: SingleUserSearchCommand): User
    fun checkEmailDuplicate(duplicateCheckCommand: DuplicateCheckCommand): Boolean
    fun saveUser(userSaveCommand: UserSaveCommand): User
    fun getAllUsers(multipleUserSearchCommand: MultipleUserSearchCommand): List<User>
}
