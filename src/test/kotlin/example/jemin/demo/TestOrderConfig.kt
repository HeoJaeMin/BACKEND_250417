package example.jemin.demo

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.SpecExecutionOrder
import org.springframework.boot.test.context.TestConfiguration

@TestConfiguration
class TestOrderConfig : AbstractProjectConfig() {
    override val specExecutionOrder = SpecExecutionOrder.Lexicographic
}
