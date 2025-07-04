package example.jemin.demo.modules.user.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository :
    JpaRepository<UserEntity, Long>,
    UserJdslRepository {
    fun findByEmailOrNickName(email: String?, nickName: String?): Optional<UserEntity>
}
