package example.jemin.demo.config.exception.handler

import example.jemin.demo.common.ErrorResponse
import example.jemin.demo.config.exception.error.unit.BadRequestError
import example.jemin.demo.config.exception.error.unit.NotFoundError
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Operation(summary = "Internal Server Error", description = "Internal Server Error")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "500", description = "처리 중 오류가 발생했습니다."),
        ],
    )
    internal fun handleRuntimeException(e: RuntimeException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(message = e.message ?: "Internal Server Error"))

    @ExceptionHandler(NotFoundError::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Operation(summary = "Not Found", description = "찾을 수 없습니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "404", description = "Not Found"),
        ],
    )
    internal fun handleNotFound(e: NotFoundError): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                message = e.message ?: "Not Found",
                details = e.errorDetail,
            ),
        )

    @ExceptionHandler(BadRequestError::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    internal fun handleBadRequest(e: BadRequestError): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse(
                message = e.message ?: "Bad Request",
            ),
        )
}
