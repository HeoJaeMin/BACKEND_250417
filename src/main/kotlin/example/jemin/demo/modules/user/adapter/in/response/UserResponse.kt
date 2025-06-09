package example.jemin.demo.modules.user.adapter.`in`.response

import example.jemin.demo.modules.user.domain.User

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val address: String?,
    val profilePictureUrl: String?,
    val backgroundPictureUrl: String?,
) {
    constructor(user: User) : this(
        id = user.id!!,
        name = user.name,
        email = user.email,
        phone = user.phone,
        address = user.address,
        profilePictureUrl = user.profilePictureUrl,
        backgroundPictureUrl = user.backgroundPictureUrl,
    )
}
