package example.jemin.demo.common.config.exception.error.extend

import example.jemin.demo.common.config.exception.error.unit.BadRequestError
import example.jemin.demo.common.response.ErrorDetail

class UserDuplicateError(
    override val cause: Throwable? = null,
    override val errorDetail: List<ErrorDetail> = listOf(),
) : BadRequestError(cause, errorDetail)
