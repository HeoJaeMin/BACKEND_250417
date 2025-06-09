package example.jemin.demo.modules.user.adapter.out

import example.jemin.demo.modules.user.adapter.out.persistence.UserEntity
import example.jemin.demo.modules.user.adapter.out.persistence.UserRepository
import example.jemin.demo.modules.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.modules.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.modules.user.application.port.out.UserPort
import example.jemin.demo.modules.user.domain.User
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class UserAdapter(private val userRepository: UserRepository) : UserPort {
    override fun save(user: User): User = userRepository
        .save(UserEntity(user)).toDomain()

    override fun delete(user: User) {
        val exist = userRepository.findById(user.id!!).orElseThrow {
            throw RuntimeException()
        }
        userRepository.delete(exist)
    }

    override fun findById(id: Long) = userRepository.findById(id).getOrNull()?.toDomain()
    override fun checkDuplicate(duplicateCheckCommand: DuplicateCheckCommand): Boolean =
        userRepository.findByEmailOrNickName(duplicateCheckCommand.email, duplicateCheckCommand.nickName).isPresent

    override fun findAll(multipleUserSearchCommand: MultipleUserSearchCommand): List<User> =
        userRepository.findByCommand(multipleUserSearchCommand).map { it.toDomain() }
}
