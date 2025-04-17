package example.jemin.demo

import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@ActiveProfiles("test")
@ContextConfiguration(classes = [DemoApplication::class])
abstract class CustomBehaviorSpec(body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {
    override fun extensions(): List<Extension> = listOf(SpringExtension)
}
