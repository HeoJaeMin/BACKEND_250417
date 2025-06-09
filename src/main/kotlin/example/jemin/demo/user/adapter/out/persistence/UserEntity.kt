package example.jemin.demo.user.adapter.out.persistence

import example.jemin.demo.common.config.jpa.TimeSuperclass
import example.jemin.demo.user.domain.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(
    name = "\"user\"",
    uniqueConstraints = [UniqueConstraint(columnNames = ["email"]), UniqueConstraint(columnNames = ["nickName"])],
)
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "nick_name", nullable = false)
    val nickName: String,
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "phone", nullable = false)
    val phone: String,
    @Column(name = "address", nullable = true)
    val address: String?,
    @Column(name = "profile_picture_url", nullable = true)
    val profilePictureUrl: String?,
    @Column(name = "background_picture_url", nullable = true)
    val backgroundPictureUrl: String?,
) : TimeSuperclass() {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        nickName = user.nickName,
        email = user.email,
        phone = user.phone,
        address = user.address,
        profilePictureUrl = user.profilePictureUrl,
        backgroundPictureUrl = user.backgroundPictureUrl,
    )

    fun toDomain() = User(
        id = id,
        name = name,
        nickName = nickName,
        email = email,
        phone = phone,
        address = address,
        profilePictureUrl = profilePictureUrl,
        backgroundPictureUrl = backgroundPictureUrl,
    )
}
