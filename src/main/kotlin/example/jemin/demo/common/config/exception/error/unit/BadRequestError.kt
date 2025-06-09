package example.jemin.demo.common.config.exception.error.unit

import example.jemin.demo.common.response.ErrorDetail

open class BadRequestError(override val cause: Throwable? = null, open val errorDetail: List<ErrorDetail> = listOf()) :
    RuntimeException("올바르지 않은 요청입니다.", cause)
