package example.jemin.demo.modules.user.application.port.`in`.command

data class MultipleUserSearchCommand(
    val name: String?,
    val nickName: String?,
    val email: String?,
    val phone: String?,
    val address: String?,
)
