package example.jemin.demo.common

data class ErrorResponse(val message: String, val details: List<ErrorDetail> = emptyList())
