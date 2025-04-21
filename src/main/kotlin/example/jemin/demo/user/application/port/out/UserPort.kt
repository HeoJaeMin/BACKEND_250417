package example.jemin.demo.user.application.port.out

import example.jemin.demo.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.user.domain.User

interface UserPort {
    fun save(user: User): User

    fun delete(user: User)

    fun findById(id: Long): User?
    fun checkDuplicate(duplicateCheckCommand: DuplicateCheckCommand): Boolean
}
