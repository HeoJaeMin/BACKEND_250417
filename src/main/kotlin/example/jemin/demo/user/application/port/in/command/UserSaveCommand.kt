package example.jemin.demo.user.application.port.`in`.command

import example.jemin.demo.user.domain.User

data class UserSaveCommand(
    val id: Long?,
    val name: String,
    val email: String,
    val phone: String,
    val address: String?,
    val profilePictureUrl: String?,
    val backgroundPictureUrl: String?,
) {
    fun toDomain() = User(
        id = id,
        name = name,
        email = email,
        phone = phone,
        address = address,
        profilePictureUrl = profilePictureUrl,
        backgroundPictureUrl = backgroundPictureUrl,
    )
}
