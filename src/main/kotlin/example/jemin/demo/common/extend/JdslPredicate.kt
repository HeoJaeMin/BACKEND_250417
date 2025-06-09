package example.jemin.demo.common.extend

import com.linecorp.kotlinjdsl.querymodel.jpql.expression.Expressions
import com.linecorp.kotlinjdsl.querymodel.jpql.path.Path
import com.linecorp.kotlinjdsl.querymodel.jpql.predicate.Predicates

fun String?.toPredicate(path: Path<String>) = this.takeIf { !it.isNullOrEmpty() }?.let {
    Predicates.like(path, Expressions.value("%$it%"))
}
