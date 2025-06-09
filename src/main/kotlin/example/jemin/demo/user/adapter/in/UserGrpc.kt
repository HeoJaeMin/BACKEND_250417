package example.jemin.demo.user.adapter.`in`

import example.jemin.demo.UserGrpcAdapterGrpc
import example.jemin.demo.user.application.port.`in`.UserUseCase
import example.jemin.demo.user.application.port.`in`.command.MultipleUserSearchCommand
import example.jemin.demo.user.domain.User
import example.jemin.demo.userProto
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
