package example.jemin.demo.modules.user.domain

data class User(
    val id: Long?,
    val name: String,
    val nickName: String,
    val email: String,
    val phone: String,
    val address: String?,
    val profilePictureUrl: String?,
    val backgroundPictureUrl: String?,
)
