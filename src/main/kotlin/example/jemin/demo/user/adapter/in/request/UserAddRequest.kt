package example.jemin.demo.user.adapter.`in`.request

import example.jemin.demo.user.application.port.`in`.command.UserSaveCommand
import io.swagger.v3.oas.annotations.media.Schema

data class UserAddRequest(
    @Schema(description = "이름")
    val name: String,
    @Schema(description = "별명")
    val nickName: String,
    @Schema(description = "이메일")
    val email: String,
    @Schema(description = "전화번호")
    val phone: String,
    @Schema(description = "주소")
    val address: String?,
) {
    fun toCommand() = UserSaveCommand(
        id = null,
        name = name,
        nickName = nickName,
        email = email,
        phone = phone,
        address = address,
        profilePictureUrl = null,
        backgroundPictureUrl = null,
    )
}
