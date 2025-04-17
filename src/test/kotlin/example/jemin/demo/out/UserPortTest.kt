package example.jemin.demo.out

import example.jemin.demo.CustomBehaviorSpec
import example.jemin.demo.user.application.port.out.UserPort
import example.jemin.demo.user.domain.User
import io.kotest.matchers.shouldBe

class UserPortTest(private val userPort: UserPort) :
    CustomBehaviorSpec({
        Given("ADD USER") {
            val user =
                User(
                    id = null,
                    name = "Jemin",
                    email = "rfvgbn21@naver.com",
                    phone = "010-1234-5678",
                    address = "서울시 서달로",
                    profilePictureUrl = null,
                    backgroundPictureUrl = null,
                )

            When("save user") {
                val result = userPort.save(user)
                val userId = result.id
                Then("result should not be null") {
                    result.name shouldBe user.name
                    result.email shouldBe user.email
                    result.phone shouldBe user.phone
                }
                When("find user by id") {
                    val foundUser = userPort.findUser(userId!!)
                    Then("found user should be same as saved user") {
                        foundUser shouldBe result
                    }
                    When("delete user") {
                        userPort.delete(result)
                        Then("user should not be found") {
                            userPort.findUser(userId) shouldBe null
                        }
                    }
                }
            }
        }
    })
