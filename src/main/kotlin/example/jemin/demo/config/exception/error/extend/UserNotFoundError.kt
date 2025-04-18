package example.jemin.demo.config.exception.error.extend

import example.jemin.demo.common.ErrorDetail
import example.jemin.demo.config.exception.error.unit.NotFoundError

class UserNotFoundError(
    override val cause: Throwable? = null,
    override val errorDetail: List<ErrorDetail> = listOf(),
) : NotFoundError(
    notFoundIs = "사용자",
    cause = cause,
    errorDetail = errorDetail,
)
