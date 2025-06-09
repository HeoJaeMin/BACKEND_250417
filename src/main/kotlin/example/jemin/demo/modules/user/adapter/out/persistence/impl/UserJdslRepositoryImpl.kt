package example.jemin.demo.modules.user.adapter.out.persistence.impl

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import example.jemin.demo.common.extend.toPredicate
import example.jemin.demo.modules.user.adapter.out.persistence.UserEntity
import example.jemin.demo.modules.user.adapter.out.persistence.UserJdslRepository
import example.jemin.demo.modules.user.application.port.`in`.command.MultipleUserSearchCommand
import org.springframework.stereotype.Component

@Component
class UserJdslRepositoryImpl(private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor) : UserJdslRepository {
    override fun findByCommand(multipleUserSearchCommand: MultipleUserSearchCommand): List<UserEntity> =
        kotlinJdslJpqlExecutor.findAll {
            select(entity(UserEntity::class)).from(entity(UserEntity::class))
                .whereAnd(
                    multipleUserSearchCommand.name.toPredicate(path(UserEntity::name)),
                    multipleUserSearchCommand.nickName.toPredicate(path(UserEntity::nickName)),
                    multipleUserSearchCommand.email.toPredicate(path(UserEntity::email)),
                    multipleUserSearchCommand.phone.toPredicate(path(UserEntity::phone)),
                    multipleUserSearchCommand.address.toPredicate(path(UserEntity::address)),
                )
        }.filterNotNull()
}
