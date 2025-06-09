package example.jemin.demo.modules.user.adapter.`in`

import example.jemin.demo.modules.user.UserGrpcAdapterGrpc
import example.jemin.demo.modules.user.application.port.`in`.UserUseCase
import example.jemin.demo.modules.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.modules.user.domain.User
import example.jemin.demo.modules.user.userProto
import io.grpc.stub.StreamObserver
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class UserGrpc(
    private val userUseCase: UserUseCase,
) : UserGrpcAdapterGrpc.UserGrpcAdapterImplBase() {
    override fun getUser(
        request: userProto.UserRequest,
        responseObserver: StreamObserver<userProto.UserListResponse>,
    ) {
        responseObserver.onNext(
            userProto.UserListResponse.newBuilder().addAllResponses(
                userUseCase.getAllUsers(request.toCommand()).map { it.toResponse() },
            ).build(),
        )
        responseObserver.onCompleted()
    }

    private fun User.toResponse() = userProto.UserResponse.newBuilder()
        .setNickName(this.nickName)
        .setName(this.name)
        .setEmail(this.email)
        .setPhone(this.phone)
        .setAddress(this.address.toNotNull())
        .setProfilePictureUrl(this.profilePictureUrl.toNotNull())
        .setBackgroundPictureUrl(this.backgroundPictureUrl.toNotNull())
        .build()

    private fun userProto.UserRequest.toCommand() = MultipleUserSearchCommand(
        name = this.name,
        nickName = this.nickName,
        email = this.email,
        phone = this.phone,
        address = this.address,
    )

    private fun String?.toNotNull() = this ?: ""
}
