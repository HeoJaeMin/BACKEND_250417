package example.jemin.demo.user.adapter.out

import example.jemin.demo.user.adapter.out.persistence.UserEntity
import example.jemin.demo.user.adapter.out.persistence.UserRepository
import example.jemin.demo.user.application.port.out.UserPort
import example.jemin.demo.user.domain.User
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class UserAdapter(private val userRepository: UserRepository) : UserPort {
    override fun save(user: User): User = userRepository
        .save(
            UserEntity(user),
        ).toDomain()

    override fun delete(user: User) {
        val user = userRepository.findById(user.id!!).orElseThrow()
        userRepository.delete(user)
    }

    override fun findUser(id: Long) = userRepository.findById(id).getOrNull()?.toDomain()
}
