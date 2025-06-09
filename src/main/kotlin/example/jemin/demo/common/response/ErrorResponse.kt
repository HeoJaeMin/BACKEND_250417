package example.jemin.demo.common.response

data class ErrorResponse(val message: String, val details: List<ErrorDetail> = emptyList())
