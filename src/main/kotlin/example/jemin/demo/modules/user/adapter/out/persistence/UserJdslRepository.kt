package example.jemin.demo.modules.user.adapter.out.persistence

import example.jemin.demo.modules.user.application.port.`in`.command.MultipleUserSearchCommand

interface UserJdslRepository {
    fun findByCommand(multipleUserSearchCommand: MultipleUserSearchCommand): List<UserEntity>
}
