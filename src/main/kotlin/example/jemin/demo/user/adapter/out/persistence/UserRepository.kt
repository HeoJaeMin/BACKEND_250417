package example.jemin.demo.user.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByEmailOrNickName(email: String?, nickName: String?): Optional<UserEntity>
}
