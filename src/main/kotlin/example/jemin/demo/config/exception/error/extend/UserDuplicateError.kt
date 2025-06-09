package example.jemin.demo.config.exception.error.extend

import example.jemin.demo.common.ErrorDetail
import example.jemin.demo.config.exception.error.unit.BadRequestError

class UserDuplicateError(
    override val cause: Throwable? = null,
    override val errorDetail: List<ErrorDetail> = listOf(),
) : BadRequestError(cause, errorDetail)
