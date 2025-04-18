package example.jemin.demo.user.adapter.`in`

import example.jemin.demo.common.CommonResponse
import example.jemin.demo.user.adapter.`in`.request.UserAddRequest
import example.jemin.demo.user.adapter.`in`.response.DuplicateCheckResponse
import example.jemin.demo.user.adapter.`in`.response.UserResponse
import example.jemin.demo.user.application.port.`in`.UserUseCase
import example.jemin.demo.user.application.port.`in`.command.EmailDuplicateCheckCommand
import example.jemin.demo.user.application.port.`in`.command.UserSearchCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userUseCase: UserUseCase,
) {
    @GetMapping("/{id}")
    fun getUser(
        @PathVariable id: Long,
    ): ResponseEntity<CommonResponse<UserResponse>> =
        ResponseEntity.ok(
            CommonResponse(
                UserResponse(
                    userUseCase.getUser(
                        UserSearchCommand(id),
                    ),
                ),
            ),
        )

    @GetMapping
    fun checkEmailDuplicate(
        @RequestParam("email") email: String,
    ): ResponseEntity<CommonResponse<DuplicateCheckResponse>> =
        ResponseEntity.ok(
            CommonResponse(
                DuplicateCheckResponse(
                    userUseCase.checkEmailDuplicate(EmailDuplicateCheckCommand(email)),
                ),
            ),
        )

    @PostMapping
    fun addUser(
        @RequestBody userAddRequest: UserAddRequest,
    ): ResponseEntity<CommonResponse<UserResponse>> = ResponseEntity.ok(
        CommonResponse(
            UserResponse(
                userUseCase.saveUser(userAddRequest.toCommand()),
            ),
        ),
    )
}
