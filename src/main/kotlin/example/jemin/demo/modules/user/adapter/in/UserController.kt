package example.jemin.demo.modules.user.adapter.`in`

import example.jemin.demo.common.response.CommonResponse
import example.jemin.demo.modules.user.adapter.`in`.request.UserAddRequest
import example.jemin.demo.modules.user.adapter.`in`.response.DuplicateCheckResponse
import example.jemin.demo.modules.user.adapter.`in`.response.UserResponse
import example.jemin.demo.modules.user.application.port.`in`.UserUseCase
import example.jemin.demo.modules.user.application.port.`in`.command.DuplicateCheckCommand
import example.jemin.demo.modules.user.application.port.`in`.command.SingleUserSearchCommand
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
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
@Tag(name = "User API", description = "사용자 정보 API")
class UserController(
    private val userUseCase: UserUseCase,
) {
    @GetMapping("/{id}")
    @Operation(summary = "단일 사용자 조회", description = "ID로 사용자 조회")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "성공적으로 사용자 조회",
            ),
        ],
    )
    fun getUser(
        @PathVariable id: Long,
    ): ResponseEntity<CommonResponse<UserResponse>> =
        ResponseEntity.ok(
            CommonResponse(
                UserResponse(
                    userUseCase.getUser(
                        SingleUserSearchCommand(id),
                    ),
                ),
            ),
        )

    @GetMapping("/email/check")
    @Operation(summary = "이메일 중복 조회", description = "회원가입 전 이메일 중복 조회")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "이메일 중복 확인",
            ),
        ],
    )
    fun checkEmailDuplicate(
        @RequestParam("email") email: String,
    ): ResponseEntity<CommonResponse<DuplicateCheckResponse>> =
        ResponseEntity.ok(
            CommonResponse(
                DuplicateCheckResponse(
                    userUseCase.checkEmailDuplicate(
                        DuplicateCheckCommand(
                            email = email,
                            nickName = null,
                        ),
                    ),
                ),
            ),
        )

    @GetMapping("/nickName/check")
    @Operation(summary = "별명 중복 체크", description = "별명 중복 조회")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "별명 중복 여부 확인",
            ),
        ],
    )
    fun checkNickNameDuplicate(
        @RequestParam("nickName") nickName: String,
    ): ResponseEntity<CommonResponse<DuplicateCheckResponse>> = ResponseEntity.ok(
        CommonResponse(
            DuplicateCheckResponse(
                userUseCase.checkEmailDuplicate(
                    DuplicateCheckCommand(
                        email = null,
                        nickName = nickName,
                    ),
                ),
            ),
        ),
    )

    @PostMapping
    @Operation(summary = "유저 등록", description = "회원가입")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "회원 가입 성공",
            ),
        ],
    )
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
