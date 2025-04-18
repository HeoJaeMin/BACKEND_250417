package example.jemin.demo.config.exception.error.unit

import example.jemin.demo.common.ErrorDetail

open class NotFoundError(
    notFoundIs: String,
    override val cause: Throwable? = null,
    open val errorDetail: List<ErrorDetail> = listOf(),
) : RuntimeException("${notFoundIs}을/를 확인할 수 없습니다.", cause)
