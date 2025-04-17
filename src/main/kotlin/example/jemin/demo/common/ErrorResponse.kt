package example.jemin.demo.common

data class ErrorResponse(val message: String, val details: List<ErrorDetail> = emptyList()) {
    data class ErrorDetail(val reason: String, val message: String)
}
