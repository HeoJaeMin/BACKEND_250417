package example.jemin.demo.user.domain

data class User(
    val id: Long?,
    val name: String,
    val email: String,
    val phone: String,
    val address: String?,
    val profilePictureUrl: String?,
    val backgroundPictureUrl: String?,
)
