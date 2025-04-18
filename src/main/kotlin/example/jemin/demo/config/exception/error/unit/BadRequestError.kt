package example.jemin.demo.config.exception.error.unit

import example.jemin.demo.common.ErrorDetail

open class BadRequestError(override val cause: Throwable? = null, val errorDetail: List<ErrorDetail> = listOf()) :
    RuntimeException("올바르지 않은 요청입니다.", cause)
