package example.jemin.demo.user.adapter.`in`.request

import example.jemin.demo.user.application.port.`in`.command.UserSaveCommand

data class UserAddRequest(
    val name: String,
    val email: String,
    val phone: String,
    val address: String?,
) {
    fun toCommand() = UserSaveCommand(
        id = null,
        name = name,
        email = email,
        phone = phone,
        address = address,
        profilePictureUrl = null,
        backgroundPictureUrl = null,
    )
}
