package example.jemin.demo.modules.user.application.port.`in`.command

import example.jemin.demo.modules.user.domain.User

data class UserSaveCommand(
    val id: Long?,
    val name: String,
    val nickName: String,
    val email: String,
    val phone: String,
    val address: String?,
    val profilePictureUrl: String?,
    val backgroundPictureUrl: String?,
) {
    fun toDomain() = User(
        id = id,
        name = name,
        nickName = nickName,
        email = email,
        phone = phone,
        address = address,
        profilePictureUrl = profilePictureUrl,
        backgroundPictureUrl = backgroundPictureUrl,
    )
}
