package example.jemin.demo.common.config.exception.error.extend

import example.jemin.demo.common.config.exception.error.unit.NotFoundError
import example.jemin.demo.common.response.ErrorDetail

class UserNotFoundError(
    override val cause: Throwable? = null,
    override val errorDetail: List<ErrorDetail> = listOf(),
) : NotFoundError(
    notFoundIs = "사용자",
    cause = cause,
    errorDetail = errorDetail,
)
