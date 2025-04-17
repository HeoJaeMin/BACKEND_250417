package example.jemin.demo.common

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class PagedResponse<T>(
    content: List<T>,
    page: Int,
    size: Int,
    totalElements: Long,
) : PageImpl<T>(
    content,
    Pageable.ofSize(size).withPage(page),
    totalElements,
)
