package example.jemin.demo.user.adapter.out.persistence

import example.jemin.demo.user.application.port.`in`.command.MultipleUserSearchCommand

interface UserJdslRepository {
    fun findByCommand(multipleUserSearchCommand: MultipleUserSearchCommand): List<UserEntity>
}
