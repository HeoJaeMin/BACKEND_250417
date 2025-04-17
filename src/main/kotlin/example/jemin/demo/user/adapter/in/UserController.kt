package example.jemin.demo.user.adapter.`in`

import example.jemin.demo.common.CommonResponse
import example.jemin.demo.user.adapter.`in`.response.UserResponse
import example.jemin.demo.user.application.port.`in`.UserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userUseCase: UserUseCase,
) {
    @GetMapping("/{id}")
    fun getUser(
        @PathVariable id: Long,
    ): ResponseEntity<CommonResponse<UserResponse>> = ResponseEntity.ok(CommonResponse(UserResponse(userUseCase.getUser(id))))
}
