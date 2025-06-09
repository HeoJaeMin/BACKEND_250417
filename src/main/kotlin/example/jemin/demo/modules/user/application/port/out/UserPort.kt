package example.jemin.demo.modules.user.application.port.out

import example.jemin.demo.modules.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.modules.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.modules.user.domain.User

interface UserPort {
    fun save(user: User): User
    fun delete(user: User)
    fun findById(id: Long): User?
    fun checkDuplicate(duplicateCheckCommand: DuplicateCheckCommand): Boolean
    fun findAll(multipleUserSearchCommand: MultipleUserSearchCommand): List<User>
}
